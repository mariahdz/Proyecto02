package com.proyectos.lucasteam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.proyectos.lucasteam.model.Juego;

/**
 * Interfaz: JuegoRepository <br>
 * @author María Hernández
 * @version 24/06/2021/A
 */

@Repository
public interface JuegoRepository extends JpaRepository<Juego,Integer>{

}
