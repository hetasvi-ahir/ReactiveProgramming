package com.ims.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ims.dto.ResponseVO;
import com.ims.entity.Admin;
import com.ims.repository.AdminRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class AdminHandler {

	@Autowired
	private AdminRepository adminRepository;

	/**
	 * 
	 * @param serverRequest
	 * @return Mono<ServerResponse> {@summary This method is to save admin}
	 */
	public Mono<ServerResponse> saveAdmin(ServerRequest serverRequest) {

		Mono<Admin> admin = serverRequest.bodyToMono(Admin.class);
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();

		Mono<ResponseVO<Admin>> map =
				admin.flatMap(adminRepository::save)
				.map(admin2 -> ResponseVO.create(200, "Admin successfully Registered", admin2));

		return ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(map, Admin.class)
				.switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> getAdminList(ServerRequest request) {
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();

		Flux<Admin> adminList = adminRepository.findAll().log();
		Mono<List<Admin>> collectList = adminList.collectList();
		Mono<ResponseVO<List<Admin>>> response = collectList.map(e -> ResponseVO.create(200, "List of Admins :", e));

		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, Admin.class)
				.switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> getAdminById(ServerRequest request) {
		String adminId = request.pathVariable("id");

		Mono<ServerResponse> notFound = ServerResponse.notFound().build();

		Mono<Admin> findById = adminRepository.findById(Long.valueOf(adminId));
		Mono<ResponseVO<Admin>> map = findById.map(e -> ResponseVO.create(200, "Found Admin for ", e));
		return ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(map, Admin.class)
				.switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> updateAdmin(ServerRequest request)

	{
		Mono<Admin> admin = request.bodyToMono(Admin.class);
		Mono<ServerResponse> notFound = ServerResponse.notFound().build();

		Mono<ResponseVO<Admin>> map = admin.flatMap(adminRepository::save)
				.map(admin2 -> ResponseVO.create(200, "Admin Updated Successfully", admin2));

		return ServerResponse.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(map, Admin.class)
				.switchIfEmpty(notFound);

	}

	public Mono<ServerResponse> deleteAdminById(ServerRequest request) {
		Long adminId = Long.valueOf(request.pathVariable("id"));

		if (adminId != null) {

			Mono<ResponseVO<Void>> thenReturn = adminRepository.deleteById(adminId)
					.thenReturn(ResponseVO.create(200, "Admin Deleted Successfully "));

			return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(thenReturn, ResponseVO.class);
		} else {
			return ServerResponse.notFound().build(Mono.empty());
		}

	}

}
