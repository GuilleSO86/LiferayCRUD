package com.ricoh.test.liferay.entities;

import java.util.Set;

public class Marca {
	
	private Integer idMarca;
	private String nombre;
	private String aniofundacion;
	private String nacionalidad;
	private Set<Coche> coches;
	
	
	public Marca() {
		super();
	}


	public Marca(Integer idMarca, String nombre, String aniofundacion, String nacionalidad, Set<Coche> coches) {
		super();
		this.idMarca = idMarca;
		this.nombre = nombre;
		this.aniofundacion = aniofundacion;
		this.nacionalidad = nacionalidad;
		this.coches = coches;
	}


	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAniofundacion() {
		return aniofundacion;
	}

	public void setAniofundacion(String aniofundacion) {
		this.aniofundacion = aniofundacion;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Set<Coche> getCoches() {
		return coches;
	}

	public void setCoches(Set<Coche> coches) {
		this.coches = coches;
	}


	@Override
	public String toString() {
		return "Marca [idMarca=" + idMarca + ", nombre=" + nombre + ", aniofundacion=" + aniofundacion
				+ ", nacionalidad=" + nacionalidad + "]";
	}
	
}
