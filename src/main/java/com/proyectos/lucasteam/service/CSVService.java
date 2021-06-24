package com.proyectos.lucasteam.service;

	import java.util.List;
	import java.util.Map;

	import com.proyectos.lucasteam.model.Juego;

	public interface CSVService {
		
		public List<Juego> cargaInicial();
		
		public void SaveListaJuegos(List<Juego> listaJuegos);
	}



