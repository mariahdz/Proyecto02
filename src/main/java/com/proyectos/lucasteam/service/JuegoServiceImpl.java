package com.proyectos.lucasteam.service;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
@Transactional
public class JuegoServiceImpl implements JuegoService {
	
	@Autowired
	JuegoRepository juegoRepository;
	

	
	public JuegoServiceImpl(){
		super();
	}
	
	
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
		
		public static final String SEPARATOR = ",";
		//private Map<Integer, Juego> inventario = new HashMap<>();
		List <Juego> listaJuegos = new ArrayList<Juego>();
		
		//lectura csv
		public List<Juego> cargaInicial() {
			BufferedReader br = null;
			Juego juego;

			try {

				br = new BufferedReader(new FileReader("data/vgsales1.csv"));
				br.readLine();
				String line = br.readLine();

				while (null != line) {
					String[] fields = line.split(SEPARATOR);
					juego = lineToJuego(fields);
					if (juego != null)
						listaJuegos.add(juego);
					line = br.readLine();
				}
				if (null != br)
					br.close();

			} catch (Exception e) {

				System.out.println(e.getMessage());
			}

			return listaJuegos;
		}

		
		
		private Juego lineToJuego(String[] linea) {
			Juego juego = null;
			try {
				juego = new Juego(linea);
			
			}catch(Exception e){
				e.getMessage();
			}
			return juego;
		}

		@Override
		public Page<Juego> findAll(PageRequest pageRequest) {
			return juegoRepository.findAll(pageRequest);
		}

		
	
		
		

	}
		

