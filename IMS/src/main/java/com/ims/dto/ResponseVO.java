package com.ims.dto;

import lombok.Data;

@Data
public class ResponseVO<T> {

	private Integer code;

	private String message;

	private T result;

	public static <T> ResponseVO<T> create(Integer code, String message, T data) {
		ResponseVO<T> vo = new ResponseVO<>();
		vo.code = code;
		vo.message = message;
		vo.result = data;
		return vo;
	}

	public static <T> ResponseVO<T> create(Integer code, T data) {
		ResponseVO<T> vo = new ResponseVO<>();
		vo.code = code;
		vo.message = "";
		vo.result = data;
		return vo;
	}

	public static ResponseVO<Void> create(Integer code, String message) {
		ResponseVO<Void> vo = new ResponseVO<>();
		vo.code = code;
		vo.message = message;
		return vo;
	}
}