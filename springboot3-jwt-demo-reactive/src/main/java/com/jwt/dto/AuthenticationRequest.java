package com.jwt.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
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
public class AuthenticationRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotBlank
	private String username;

	@NotBlank
	private String password;

}
