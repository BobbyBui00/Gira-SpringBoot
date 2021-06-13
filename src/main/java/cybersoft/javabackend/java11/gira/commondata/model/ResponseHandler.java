package cybersoft.javabackend.java11.gira.commondata.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import cybersoft.javabackend.java11.gira.utils.ErrorsUtils;
import cybersoft.javabackend.java11.gira.utils.ListUtils;

public class ResponseHandler {
	
	// Return result
	public static ResponseEntity<Object> getResponse(Object content, HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("content", content);
		map.put("message", ListUtils.emptyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	// Return errors
	public static ResponseEntity<Object> getResponse(BindingResult bindingResult, HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("content", ListUtils.emptyStringList);
		map.put("message", ErrorsUtils.getErrorsMessage(bindingResult));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	// No return, passing string error
	public static ResponseEntity<Object> getResponse(String error, HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("content", ListUtils.emptyStringList);
		map.put("message", ErrorsUtils.errorOf(error));
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
	// Passing only HttpStatus
	public static ResponseEntity<Object> getResponse(HttpStatus status) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("content", ListUtils.emptyStringList);
		map.put("message", ListUtils.emptyStringList);
		map.put("status", status.value());
		
		return new ResponseEntity<>(map, status);
	}
	
}
