package com.proyecto.foodie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MappedSuperclass;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuarios {
	
	@Id
	private String dniUsuario;
	
	private String nombreUsuario;
	private String apellidosUsuario;
	@Column(unique=true)
	private int telefonoUsuario;
	@Column(unique=true)
	private String correoElectronico;
	private String contrasena;
	private String tipoUsuario;
	
	@ManyToMany(mappedBy="listaUsuarios")
	private List<Platos> listaPlatos;
	
	public Usuarios() {}

	public Usuarios(String dniUsuario, String nombreUsuario, String apellidosUsuario, int telefonoUsuario,
			String correoElectronico, String contrasena, String tipoUsuario) {
		this.dniUsuario = dniUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidosUsuario = apellidosUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.correoElectronico = correoElectronico;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
	}

	public String getdniUsuario() {
		return dniUsuario;
	}

	public void setdniUsuario(String dniUsuario) {
		this.dniUsuario = dniUsuario;
	}

	public String getnombreUsuario() {
		return nombreUsuario;
	}

	public void setnombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getapellidosUsuario() {
		return apellidosUsuario;
	}

	public void setapellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public int gettelefonoUsuario() {
		return telefonoUsuario;
	}

	public void settelefonoUsuario(int telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getcorreoElectronico() {
		return correoElectronico;
	}

	public void setcorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String gettipoUsuario() {
		return tipoUsuario;
	}

	public void settipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public List<Platos> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(List<Platos> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

	@Override
	public String toString() {
		return "Usuarios [dniUsuario=" + dniUsuario + ", nombreUsuario=" + nombreUsuario + ", apellidosUsuario="
				+ apellidosUsuario + ", telefonoUsuario=" + telefonoUsuario + ", correoElectronico="
				+ correoElectronico + ", contrasena=" + contrasena + ", tipoUsuario=" + tipoUsuario + "]";
	}
}
