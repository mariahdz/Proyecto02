package com.proyectos.lucasteam.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.proyectos.lucasteam.model.Juego;
import com.proyectos.lucasteam.repository.JuegoRepository;

/**
 * Clase: CSVServiceImpl <br>
 * Descripción: Esta clase sirve para implementar los métodos necesarios para leer el fichero csv e insertar los datos en la bd
 * @author Daniela Posas
 * @version 24/06/2021/A
 */

@Service
public class CSVServiceImpl implements CSVService {
	
	@Autowired
    JuegoRepository repository;
	
	public static final String SEPARATOR = ",";
	//private Map<Integer, Juego> inventario = new HashMap<>();
	List <Juego> listaJuegos = new ArrayList<Juego>();
	
	//lectura csv
	public List<Juego> cargaInicial() {
		BufferedReader br = null;
		Juego juego;

		try {

			br = new BufferedReader(new FileReader("data/vgsales.csv"));
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
	
	
	//guardar lista en BD
	/*public void SaveListaJuegos(List <Juego> listaJuegos) {
		listaJuegos = this.cargaInicial();
		try {
        
          repository.saveAll(listaJuegos);
        
		}catch (Exception e) {
           e.getMessage();
        }
	}*/
	
		public List<Juego> saveAllAndFlush(Iterable<Juego> iterable) {
        List<Juego> list = repository.saveAll(iterable);
        repository.flush();
        return list;
    }
}
	

	
	


