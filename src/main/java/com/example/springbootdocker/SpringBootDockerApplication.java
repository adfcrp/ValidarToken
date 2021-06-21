package com.example.springbootdocker;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootdocker.Controller.VerifyToken;

@SpringBootApplication
@RestController
public class SpringBootDockerApplication {
	
	@RequestMapping("/")
	public String home(@RequestParam String token) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, URISyntaxException{
		try {
			VerifyToken.check(token);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
			// TODO Auto-generated catch block
			throw e;
		} catch (RuntimeException e) {
			return e.getMessage();
		}
		return "Válido";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDockerApplication.class, args);
	}

}