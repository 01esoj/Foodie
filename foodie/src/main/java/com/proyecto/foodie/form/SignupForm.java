package com.proyecto.foodie.form;

import jakarta.persistence.Column;

public class SignupForm {
	
	private String dniCliente;
	private String nombreCliente;
	private String apellidosCliente;
	private int telefonoCliente;
	private String correoElectronico;
	private String contrasena;
	private Long tarjetaCredito;
	
	public SignupForm() {}

	public SignupForm(String dniCliente, String nombreCliente, String apellidosCliente, int telefonoCliente,
			String correoElectronico, String contrasena, Long tarjetaCredito) {
		this.dniCliente = dniCliente;
		this.nombreCliente = nombreCliente;
		this.apellidosCliente = apellidosCliente;
		this.telefonoCliente = telefonoCliente;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		this.tarjetaCredito = tarjetaCredito;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidosCliente() {
		return apellidosCliente;
	}

	public void setApellidosCliente(String apellidosCliente) {
		this.apellidosCliente = apellidosCliente;
	}

	public int getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(int telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Long getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(Long tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	@Override
	public String toString() {
		return "SignupForm [dniCliente=" + dniCliente + ", nombreCliente=" + nombreCliente + ", apellidosCliente="
				+ apellidosCliente + ", telefonoCliente=" + telefonoCliente + ", correoElectronico=" + correoElectronico
				+ ", contrasena=" + contrasena + ", tarjetaCredito=" + tarjetaCredito + "]";
	}
	
	
}
