package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Inventario;
import com.app.web.repositorio.InventarioRepositorio;

@SpringBootApplication
public class CrudSprinBootApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CrudSprinBootApplication.class, args);
	}
	
	@Autowired
	private InventarioRepositorio repositorio;

	@Override
	public void run(String... args) throws Exception {
		/*
		Estudiante estudiante = new Estudiante("Luis", "ruz", "luis@gmail.com");
		repositorio.save(estudiante);
		
		Estudiante estudiante2 = new Estudiante("Linda", "marcela", "linda@gmail.com");
		repositorio.save(estudiante2);
		
		Estudiante estudiante3 = new Estudiante("juan", "perez", "juan@gmail.com");
		repositorio.save(estudiante3);
		*/
	}

}
