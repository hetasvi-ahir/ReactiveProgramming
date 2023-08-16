package com.jwt.router;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.dto.AuthenticationRequest;
import com.jwt.util.JwtTokenProvider;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthRouter {

	private final JwtTokenProvider tokenProvider;
	private final ReactiveAuthenticationManager authenticationManager;

	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public Mono<ResponseEntity> login(@Valid @RequestBody Mono<AuthenticationRequest> authRequest) {

		return authRequest.flatMap(login -> this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()))
				.map(this.tokenProvider::createToken)).map(jwt -> {
					HttpHeaders httpHeaders = new HttpHeaders();
					httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + jwt);
					var tokenBody = Map.of("access_token", jwt);
					return new ResponseEntity<>(tokenBody, httpHeaders, HttpStatus.OK);
				});

	}

}
