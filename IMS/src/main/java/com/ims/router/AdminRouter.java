package com.ims.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ims.handler.AdminHandler;

@Configuration
public class AdminRouter {

	@Bean
	public RouterFunction<ServerResponse> adminRoutes(AdminHandler adminHandler) {

		return RouterFunctions

				.route()
				.GET("/admin/all", adminHandler::getAdminList)
				.GET("/admin/{id}", adminHandler::getAdminById)
				.POST("/admin/save", adminHandler::saveAdmin)
				.PUT("/admin/update", adminHandler :: updateAdmin)
				.DELETE("/admin/delete/{id}", adminHandler::deleteAdminById)
				.build();
	}
}
