package com.jsp.blogapp.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStructureDTO <T>{
	private int statusCode;
	private String message;
	private T data;
	private LocalDateTime time;
}
