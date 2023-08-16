package com.jwt.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.jwt.entity.User;
import com.jwt.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Component
@RequiredArgsConstructor
public class UserHandler {

	@Autowired
	private UserRepository repository;

	/**
	 * 
	 * @param request
	 * @return {@summary Returns the Inserted User}
	 */
	public Mono<ServerResponse> createUser(ServerRequest request) {
		Mono<User> userMono = request.bodyToMono(User.class).flatMap(user -> {
			user.setPassword(user.getPassword());
			return repository.save(user);
		});

		return ServerResponse.ok().body(userMono, User.class);
	}

	/**
	 * 
	 * @param request
	 * @return {@summary Returns the user by Id}
	 */
	public Mono<ServerResponse> getUser(ServerRequest request) {

		Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		Mono<User> mono = repository.findById(request.pathVariable("id"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(mono, User.class)
				.switchIfEmpty(notFound);

	}

}
