package com.proyecto.foodie.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Empleado extends Usuarios{
	
	private double sueldo;
	private Date fechaContratacion;
	
	public Empleado() {
		super();
	}

	public Empleado(double sueldo, Date fechaContratacion) {
		super();
		this.sueldo = sueldo;
		this.fechaContratacion = fechaContratacion;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Date getFechacontratacion() {
		return fechaContratacion;
	}

	public void setFechacontratacion(Date fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}

	@Override
	public String toString() {
		return "Empleado [dniusuario=" + getdniUsuario() + ", sueldo=" + sueldo + ", fechaContratacion="
				+ fechaContratacion + "]";
	}
}
