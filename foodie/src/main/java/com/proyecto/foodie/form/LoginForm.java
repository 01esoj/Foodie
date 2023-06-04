package com.proyecto.foodie.form;

public class LoginForm {
	
	private String correo_electronico;
	private String contrasena;
	
	public String getCorreo_electronico() {
		return correo_electronico;
	}
	
	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public LoginForm() {
		super();
	}

	public LoginForm(String correo_electronico, String contrasena) {
		super();
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
	}
}
