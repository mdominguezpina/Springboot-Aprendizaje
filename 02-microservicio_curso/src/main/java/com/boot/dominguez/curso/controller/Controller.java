package com.boot.dominguez.curso.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.boot.dominguez.curso.model.Curso;

import jakarta.annotation.PostConstruct;

@RestController
public class Controller {
	
	@GetMapping("/")
	public String home() {
	    return "Bienvenido a la API de Cursos";
	}
	
	private List<Curso> cursos;
	
	@PostConstruct
	public void init() {
		cursos=new ArrayList<>();
		cursos.add(new Curso("Spring",25, "Tarde"));
		cursos.add(new Curso("Spring boot",20, "Tarde"));
		cursos.add(new Curso("Python",30, "Tarde"));
		cursos.add(new Curso("Java EE",50, "Mañana"));
		cursos.add(new Curso("Java básico",25, "Fin de semana"));
		
	}
	
	@GetMapping(value="/cursos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> getCursos(){
		return cursos;
	}
	
	@GetMapping(value="/curso", produces=MediaType.APPLICATION_JSON_VALUE)
	public Curso getCurso() {
		return new Curso("Java",100,"mañana");
	}
	
	@GetMapping(value="/curso/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Curso> buscarCursos(@PathVariable("name") String nombre){
		List<Curso> aux=new ArrayList<>();
		for(Curso curso:cursos) {
			if(curso.getNombre().contains(nombre)) {
				aux.add(curso);
			}
		}
		return aux;
	}
	
	

}
