package com.biblioteca.biblioteca_api;

import org.springframework.boot.SpringApplication;

public class TestBibliotecaApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(BibliotecaApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
