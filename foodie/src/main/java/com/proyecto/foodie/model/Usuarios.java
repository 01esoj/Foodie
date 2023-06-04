package com.proyecto.foodie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuarios {
	
	@Id
	private String dni_usuario;
	
	private String nombre_usuario;
	private String apellidos_usuario;
	@Column(unique=true)
	private int telefono_usuario;
	@Column(unique=true)
	private String correo_electronico;
	private String contrasena;
	private String tipo_usuario;
	
	@ManyToMany(mappedBy="listaUsuarios")
	private List<Platos> listaPlatos;
	
	public Usuarios() {}

	public Usuarios(String dni_usuario, String nombre_usuario, String apellidos_usuario, int telefono_usuario,
			String correo_electronico, String contrasena, String tipo_usuario) {
		this.dni_usuario = dni_usuario;
		this.nombre_usuario = nombre_usuario;
		this.apellidos_usuario = apellidos_usuario;
		this.telefono_usuario = telefono_usuario;
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
		this.tipo_usuario = tipo_usuario;
	}

	public String getDni_usuario() {
		return dni_usuario;
	}

	public void setDni_usuario(String dni_usuario) {
		this.dni_usuario = dni_usuario;
	}

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApellidos_usuario() {
		return apellidos_usuario;
	}

	public void setApellidos_usuario(String apellidos_usuario) {
		this.apellidos_usuario = apellidos_usuario;
	}

	public int getTelefono_usuario() {
		return telefono_usuario;
	}

	public void setTelefono_usuario(int telefono_usuario) {
		this.telefono_usuario = telefono_usuario;
	}

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

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
	public List<Platos> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(List<Platos> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

	@Override
	public String toString() {
		return "Usuarios [dni_usuario=" + dni_usuario + ", nombre_usuario=" + nombre_usuario + ", apellidos_usuario="
				+ apellidos_usuario + ", telefono_usuario=" + telefono_usuario + ", correo_electronico="
				+ correo_electronico + ", contrasena=" + contrasena + ", tipo_usuario=" + tipo_usuario + "]";
	}
}
