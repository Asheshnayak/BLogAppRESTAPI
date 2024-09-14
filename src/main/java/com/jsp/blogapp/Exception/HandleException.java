package com.jsp.blogapp.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.blogapp.dto.ResponseStructureDTO;

@RestControllerAdvice
public class HandleException {
	@ExceptionHandler(EntityAlreadyExistsException.class)
	public ResponseEntity<ResponseStructureDTO<String>> handleEntityAlreadyExists(EntityAlreadyExistsException e){
		ResponseStructureDTO <String>structure=new ResponseStructureDTO<>();
		structure.setStatusCode(HttpStatus.CONFLICT.value());
		structure.setMessage("Entity already exist");
		structure.setData(e.getMessage());
		structure.setTime(LocalDateTime.now());
		
		return new ResponseEntity<>(structure,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ResponseStructureDTO<String>> handleEntityNotFoundException(EntityNotFoundException e){
		ResponseStructureDTO<String> responseStructureDTO = new ResponseStructureDTO<>(HttpStatus.NOT_FOUND.value(),"entity not found",e.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(responseStructureDTO,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseStructureDTO<String>> handleException(Exception e){
		ResponseStructureDTO<String> responseStructureDTO = new ResponseStructureDTO<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal server error Please try again",e.getMessage(),LocalDateTime.now());
		return new ResponseEntity<>(responseStructureDTO,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
