package com.proyecto.foodie.model;

import java.util.Date;

import jakarta.persistence.Entity;

@Entity
public class Empleado extends Usuarios{
	
	private double sueldo;
	private Date fecha_contratacion;
	
	public Empleado() {
		super();
	}

	public Empleado(double sueldo, Date fecha_contratacion) {
		super();
		this.sueldo = sueldo;
		this.fecha_contratacion = fecha_contratacion;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Date getFecha_contratacion() {
		return fecha_contratacion;
	}

	public void setFecha_contratacion(Date fecha_contratacion) {
		this.fecha_contratacion = fecha_contratacion;
	}

	@Override
	public String toString() {
		return "Empleado [dni_usuario=" + getDni_usuario() + ", sueldo=" + sueldo + ", fecha_contratacion="
				+ fecha_contratacion + "]";
	}
}
