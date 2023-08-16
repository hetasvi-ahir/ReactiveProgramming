package com.jwt.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.jwt.entity.User;

import reactor.core.publisher.Mono;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
public interface UserRepository extends ReactiveMongoRepository<User, String> {

	/**
	 * 
	 * @param username
	 * @return Mono<User>
	 * {@summary Returns user by username}
	 */
	Mono<User> findByUsername(String username);
}
