package com.proyecto.foodie.model;

import jakarta.persistence.Entity;

@Entity
public class Admin extends Usuarios{
	
	private String historial;

	public Admin() {
		super();
	}

	public Admin(String historial) {
		super();
		this.historial = historial;
	}

	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	@Override
	public String toString() {
		return "Admin [dniUsuario=" + getDniUsuario() + ", historial=" + historial + "]";
	}
}
