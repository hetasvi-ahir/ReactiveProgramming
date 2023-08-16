package com.jwt.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.jwt.handler.UserHandler;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Configuration
public class UserRouter {

	@Bean
	public RouterFunction<ServerResponse> userRoutes(UserHandler handler) {
		return RouterFunctions.route().POST("/user/saveUser", handler::createUser)
				.GET("/user/get/{id}", handler::getUser).build();

	}
}