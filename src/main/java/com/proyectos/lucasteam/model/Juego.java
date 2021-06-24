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
	private int rank;
	private String name;
	private String platform;
	private int year;
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

	public Juego(int id, int rank, String name, String platform, int year, String genre, String publisher, double naSales,
			double euSales, double jpSales, double otherSales, double globalSales) {
		super();
		this.id = id;
		this.rank = rank;
		this.name = name;
		this.platform = platform;
		this.year = year;
		this.genre = genre;
		this.publisher = publisher;
		this.naSales = naSales;
		this.euSales = euSales;
		this.jpSales = jpSales;
		this.otherSales = otherSales;
		this.globalSales = globalSales;
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
	
	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
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
		return "Juego [id=" + id + ", rank=" + rank + ", name=" + name + ", platform=" + platform + ", year=" + year
				+ ", genre=" + genre + ", publisher=" + publisher + ", naSales=" + naSales + ", euSales=" + euSales
				+ ", jpSales=" + jpSales + ", otherSales=" + otherSales + ", globalSales=" + globalSales + "]";
	}

	
	

}
