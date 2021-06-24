package com.proyectos.lucasteam.service;

import java.util.List;
import java.util.Optional;

import com.proyectos.lucasteam.model.Juego;

/**
 * Interfaz: JuegoService <br>
 * @author María Hernández
 * @version 24/06/2021/A
 */

public interface JuegoService {
	
	//Para listar todos los juegos
	public List<Juego> findAll();
	
	//Para recuperar un juego
	public Optional <Juego> findById(int id);
	
	//Para Update & Add
	public void save(Juego juego);
	
	//Para Borrar por Id
	public void deleteById(int id);
	
	//Para listar por años
	public List<Juego> findByYear(int year);
	
	

}
