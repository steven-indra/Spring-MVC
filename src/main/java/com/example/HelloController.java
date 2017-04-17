package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(@RequestParam(value = "message", defaultValue = "Hello String") String message) {
		// return "Greetings from Spring Boot!";
		return message;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	@ResponseBody
	public String helloPost(@RequestBody String message) {
		return message;
	}

	@RequestMapping(value = "/hello/{message}")
	@ResponseBody
	public String helloUri(@PathVariable String message) {
		return message;
	}

}
