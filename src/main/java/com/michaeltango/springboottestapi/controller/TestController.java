package com.michaeltango.springboottestapi.controller;

import com.michaeltango.springboottestapi.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public TestService greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new TestService(counter.incrementAndGet(), String.format(template, name));
	}
}
