package com.jwt.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Hetasvi.Ahir
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class User {

	@Id
	private String id;

	private String username;

	private String password;

	@Email
	private String email;

	@Builder.Default()
	private boolean active = true;

	@Builder.Default()
	private List<String> roles = new ArrayList<>();

}
