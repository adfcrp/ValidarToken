package com.example.springbootdocker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdocker.Controller.VerifyToken;
import com.example.springbootdocker.Models.BodyRequest;
import com.example.springbootdocker.Models.BodyResponse;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {
	
	
	@RequestMapping("/validateToken")
	public BodyResponse validateToken(@RequestBody BodyRequest body) {
		BodyResponse bodyResponse;

		System.out.println("###############################");		

		System.out.println(body.toString());
		
		try {
			VerifyToken.check(body);
			bodyResponse = new BodyResponse(true, "Válido", null);
		} 
		catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | URISyntaxException | RuntimeException e) {
			e.printStackTrace();
			bodyResponse = new BodyResponse(e);
		}
		
		System.out.println(bodyResponse.toString());	

		System.out.println("###############################");

		return bodyResponse;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}