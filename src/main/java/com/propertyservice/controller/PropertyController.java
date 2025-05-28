package com.propertyservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.propertyservice.dto.APIResponse;
import com.propertyservice.dto.PropertyDto;
import com.propertyservice.entity.Property;
import com.propertyservice.service.PropertyService;

@RestController
@RequestMapping("/api/v1/property")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;
	
	@PostMapping(
			value = "/add-property",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,// Ensures the endpoint accepts multipart/form-data
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public ResponseEntity<APIResponse> addProperty(
			@RequestParam("property") String propertyJson,// Use RequestParam to get the property as a raw JSON string
			@RequestParam("files") MultipartFile[] files){// Use RequestParam to handle files

		//Parse the property JSON into PropertyDto
		ObjectMapper objectMapper= new ObjectMapper();
		PropertyDto dto = null;
		try {
			dto = objectMapper.readValue(propertyJson, PropertyDto.class);
		}catch(JsonProcessingException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);//Handle bad JSON
		}
		
		Property property = propertyService.addProperty(dto,files);
		
		APIResponse<Property> response = new APIResponse<>();
		response.setMessage("Property added");
		response.setStatus(201);
		response.setData(property);
		
				return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}
}
