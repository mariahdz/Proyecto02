package com.proyectos.lucasteam.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyectos.lucasteam.model.Juego;
import com.proyectos.lucasteam.service.CSVService;
import com.proyectos.lucasteam.service.JuegoService;

/**
 * Control
 * @author Desiree
 * @version 24/06/2021/A
 *
 */

@Controller
public class JuegoController {
	

	@Autowired
	JuegoService service;
	
	@Autowired
	CSVService serviceCSV;
	
	private static final Logger log = LoggerFactory.getLogger(JuegoController.class);	
	
	
	/**
	 * listar juegos
	 * @param m
	 * @return
	 */
	@GetMapping("/")
	public String listJuegos(Model m) {
		log.info("----- Inside listJuegos");
		m.addAttribute("juegosList", service.findAll());
		return "JuegosList";
	}
	
	/**
	 * 
	 * @param m
	 * @return
	 */
		@GetMapping("/listar")
		public String AñadirCSV() {
			log.info("----- Inside listJuegosCSV");
			List<Juego> listaJuegos = serviceCSV.cargaInicial();
			serviceCSV.SaveListaJuegos(listaJuegos);
			return ("redirect:/");
		}
		
		
	
	/**
	 * listar juegos por año dado
	 * @param year
	 * @param m
	 * @return
	 */
	@PostMapping("/{year}")
	public String listJuegosByYear(@RequestParam String year, Model m) {
		log.info("----- Inside listJuegosPorAño");
		m.addAttribute("juegosList", service.findByYear(Integer.valueOf(year)));
		return "JuegosList";
	}
	
	/**
	 * editar juegos
	 * @param id
	 * @param m
	 * @return
	 */
	@GetMapping("/edit")
	public String editJuego(@RequestParam("id") int id, Model m) {
		log.info("----- Inside editJuego");
		m.addAttribute("juego", service.findById(id));
		return "JuegosForm";
	}
	
	/**
	 * borra juegos
	 * @param id
	 * @return
	 */
	@GetMapping("/delete")	
	public String deleteJuego(@RequestParam("id") int id) {
		log.info("----- Inside deleteJuego");
		service.deleteById(id);
		return ("redirect:/");
	}
	
	/**
	 * nuevo juego
	 * @param user
	 * @param m
	 * @return
	 */
	@GetMapping("/new")
	public String newJuego(Juego juego, Model m) {
		log.info("----- Inside newJuego");	
		return "JuegosForm";
	}
	
	/**
	 * guardar juego
	 * @param juego
	 * @return
	 */
	@PostMapping("/save")
	public ModelAndView saveJuego(Juego juego) {
		log.info("----- Inside saveJuego");	
		service.save(juego);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/salir")
	public String salir() {
		return ("redirect:/");
	}


}
