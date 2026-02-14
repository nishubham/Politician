package com.shubham.exception;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorPage {
	
	private String message;
	private LocalTime time;
	private Integer status;

}
