package com.proyectos.lucasteam.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.proyectos.lucasteam.model.Juego;

import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;


/**
 * Interfaz: JuegoRepository <br>
 * @author María Hernández
 * @version 24/06/2021/A
 */

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer>  {
	
//	@Query(value = "SELECT * FROM juegos WHERE juegos.anio Like %?1%", nativeQuery = true)
	List<Juego> findByYear(int year);
	
	
	//List<Juego> findAllById (int id, Pageable pageable);


	
	
}