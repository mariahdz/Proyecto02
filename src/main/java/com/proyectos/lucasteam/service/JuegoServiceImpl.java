package com.proyectos.lucasteam.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectos.lucasteam.model.Juego;
import com.proyectos.lucasteam.repository.JuegoRepository;

/**
 * Clase: JuegoServiceImpl <br>
 * Descripción: Esta clase sirve para implementar los métodos necesarios
 * @author María Hernández
 * @version 24/06/2021/A
 */

@Service
public class JuegoServiceImpl implements JuegoService {
	
	@Autowired
	JuegoRepository juegoRepository;
	
	//Para listar todos los juegos
	public List<Juego> findAll(){
		return juegoRepository.findAll();
	}
	
	//Para borrar por Id
	public void deleteById(int id) {
		juegoRepository.deleteById(id);
	}

	@Override
	public Optional <Juego> findById(int id) {
		return juegoRepository.findById(id);
	}

	@Override
	public void save(Juego juego) {
		juegoRepository.save(juego);
	}
	
	//Listar por años
		public List<Juego> findByYear(int year){
			return juegoRepository.findByYear(year);
		}
	

}
