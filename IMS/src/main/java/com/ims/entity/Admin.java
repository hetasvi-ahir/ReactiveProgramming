package com.ims.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Admin {

	@Id
	private Long id;
	private String username;
	private String password;

}


