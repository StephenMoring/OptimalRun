package com.exercise.optimalRun;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OptimalRunApplication {


	public static void main(String[] args) {
		SpringApplication.run(OptimalRunApplication.class, args);
	}

	@GetMapping("/start")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("run %s!", name);
	}
}
