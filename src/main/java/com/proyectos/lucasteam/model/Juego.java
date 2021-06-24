package com.proyectos.lucasteam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clase: Juego <br>
 * Descripción: Esta clase es el modelo de datos
 * para la administración de objetos en la base de datos CSV
 * @author María Hernández
 * @version 24/06/2021/A
 */
@Entity
@Table(name="juegos")
public class Juego {
	
	private int id;
	private int rango;
	private String name;
	private String platform;
	private int anio;
	private String genre;
	private String publisher;
	private double naSales;
	private double euSales;
	private double jpSales;
	private double otherSales;
	private double globalSales;
	
	public Juego() {
		super();
	}

	public Juego(int id, int rango, String name, String platform, int anio, String genre, String publisher, double naSales,
			double euSales, double jpSales, double otherSales, double globalSales) {
		super();
		this.id = id;
		this.rango = rango;
		this.name = name;
		this.platform = platform;
		this.anio = anio;
		this.genre = genre;
		this.publisher = publisher;
		this.naSales = naSales;
		this.euSales = euSales;
		this.jpSales = jpSales;
		this.otherSales = otherSales;
		this.globalSales = globalSales;
	}
	
	public Juego(String[] line) {
		super();
		this.id = id;
		this.rango = Integer.parseInt(line[0]);
		this.name = line[1];
		this.platform = line[2];
		this.anio = Integer.parseInt(line[3]);
		this.genre = line[4];
		this.publisher = line[5];
		this.naSales = Double.parseDouble(line[6]);
		this.euSales = Double.parseDouble(line[7]);
		this.jpSales = Double.parseDouble(line[8]);
		this.otherSales = Double.parseDouble(line[9]);
		this.globalSales = Double.parseDouble(line[10]);
	}
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_juego")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRango() {
		return rango;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Column(name="anio")
	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public double getNaSales() {
		return naSales;
	}

	public void setNaSales(double naSales) {
		this.naSales = naSales;
	}
	
	
	public double getEuSales() {
		return euSales;
	}

	public void setEuSales(double euSales) {
		this.euSales = euSales;
	}

	public double getJpSales() {
		return jpSales;
	}

	public void setJpSales(double jpSales) {
		this.jpSales = jpSales;
	}

	public double getOtherSales() {
		return otherSales;
	}

	public void setOtherSales(double otherSales) {
		this.otherSales = otherSales;
	}

	public double getGlobalSales() {
		return globalSales;
	}

	public void setGlobalSales(double globalSales) {
		this.globalSales = globalSales;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", posición=" + rango + ", name=" + name + ", platform=" + platform + ", year=" + anio
				+ ", genre=" + genre + ", publisher=" + publisher + ", naSales=" + naSales + ", euSales=" + euSales
				+ ", jpSales=" + jpSales + ", otherSales=" + otherSales + ", globalSales=" + globalSales + "]";
	}

	
	

}
