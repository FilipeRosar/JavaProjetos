package com.livraria.books_on;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.security.SecureRandom;

@SpringBootApplication
@EnableCaching
public class BooksOnApplication {

	public static void main(String[] args)
    {
		SpringApplication.run(BooksOnApplication.class, args);
	}

}
