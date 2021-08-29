package com.assessment.elixir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElixirApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(ElixirApplication.class, args);
		}catch (Exception ex){
			System.out.println(ex);
		}
	}

}
