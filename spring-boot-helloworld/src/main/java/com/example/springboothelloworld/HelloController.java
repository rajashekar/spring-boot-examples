package com.example.springboothelloworld;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	private Map<String, Object> result = new HashMap<>();
	
	@RequestMapping("/hello")
	public Map<String, Object> hello() {
		result.put("name", "Raj");
		result.put("city", "Newark");
		return result;
	}
	
}
