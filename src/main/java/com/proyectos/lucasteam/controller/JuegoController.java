package com.proyectos.lucasteam.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.proyectos.lucasteam.model.Juego;
import com.proyectos.lucasteam.service.JuegoService;

/**
 * 
 * @author Desiree
 * @version 24/06/2021/A
 *
 */

@Controller
public class JuegoController {
	

	@Autowired
	JuegoService service;
	
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
	 * listar juegos por año dado
	 * @param year
	 * @param m
	 * @return
	 */
	@GetMapping("/{year}")
	public String listJuegosByYear(@RequestParam("year") int year, Model m) {
		log.info("----- Inside listJuegos");
		m.addAttribute("userList", service.findByYear(year));
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
		return "UserForm";
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
		return "UserForm";
	}
	
	/**
	 * guardar juego
	 * @param juego
	 * @return
	 */
	@PostMapping("/save")
	public ModelAndView saveUser(Juego juego) {
		log.info("----- Inside saveJuego");	
		service.save(juego);
		return new ModelAndView("redirect:/");
	}


}
