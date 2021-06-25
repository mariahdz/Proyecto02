package com.proyectos.lucasteam.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public String findAll(@RequestParam Map<String, Object> params, Model m){
		int page = params.get("page") != null ? Integer.valueOf(params.get("page").toString())-1 : 0;
		PageRequest pageRequest = PageRequest.of(page, 100);
		Page<Juego> pageJuego = service.findAll(pageRequest);
		int totalPage = pageJuego.getTotalPages();
		if(totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1,  totalPage).boxed().collect(Collectors.toList());
			m.addAttribute("pages", pages);
		}
		
		m.addAttribute("juegosList", pageJuego.getContent());
		
		
		return "JuegosList";
	}
	
	/*@GetMapping("/")
	public String listJuegos(Model m) {
		log.info("----- Inside listJuegos");
		m.addAttribute("juegosList", service.findAll());
		return "JuegosList";
	}*/
	
	/**
	 * 
	 * @param m
	 * @return
	 */
		@GetMapping("/listar")
		public String AñadirCSV() {
			log.info("----- Inside listJuegosCSV");
			List<Juego> listaJuegos = serviceCSV.cargaInicial();
			serviceCSV.saveAllAndFlush(listaJuegos);
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
