package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		new SpringApplicationBuilder(DemoApplication.class)
				.properties("server.port=8084")
				.properties("spring.threads.virtual.enabled=true")
				.run(args);
	}

//	ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
	@PostMapping("/bookAppointment")
	public ResponseEntity<String> book() {
		try {
			// Simulate DB call
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return new ResponseEntity<>("Booking Confirmed Changed", HttpStatus.OK);
	}

//	ExecutorService executor2 = Executors.newFixedThreadPool(100);
	@PostMapping("/bookAppointment2")
	public ResponseEntity<String> book2() {
		try {
			// Simulate DB call
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return new ResponseEntity<>("Booking Confirmed", HttpStatus.OK);
	}

	@GetMapping("/name")
	public String getThreadName() {
		return Thread.currentThread().toString();
	}



}
