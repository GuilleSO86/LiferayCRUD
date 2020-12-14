package com.ricoh.test.liferay.entities;

public class Coche {
	
	private Integer idCoche;
	private String modelo;
	private Integer cv;
	private Double precio;
	private Marca marca;
	
	
	public Coche() {
		super();
	}

	public Coche(Integer idCoche, String modelo, Integer cv, Double precio, Marca marca) {
		super();
		this.idCoche = idCoche;
		this.modelo = modelo;
		this.cv = cv;
		this.precio = precio;
		this.marca = marca;
	}
	

	public Integer getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(Integer idCoche) {
		this.idCoche = idCoche;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getCv() {
		return cv;
	}

	public void setCv(Integer cv) {
		this.cv = cv;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	

	@Override
	public String toString() {
		return "Coche [idCoche=" + idCoche + ", modelo=" + modelo + ", cv=" + cv + ", precio=" + precio + ", marca="
				+ marca + "]";
	}
	
}
