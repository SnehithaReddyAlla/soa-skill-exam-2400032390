package com.klef.soa.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TaskRequest 
{
	@NotBlank(message = "Name is Required")
	private String name;
	
	@NotBlank(message = "Type is required")
	private String type;

	@NotBlank(message = "Status is required")
	private String status;
	
	@NotBlank(message = "Location is required")
	private String location;
}