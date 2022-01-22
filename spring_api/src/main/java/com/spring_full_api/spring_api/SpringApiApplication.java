package com.spring_full_api.spring_api;

import java.util.Arrays;

import com.spring_full_api.spring_api.Domain.Categoria;
import com.spring_full_api.spring_api.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiApplication implements CommandLineRunner{
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");


		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
