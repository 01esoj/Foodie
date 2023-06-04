package com.proyecto.foodie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	private String dni_cliente;
	
	private String nombre_cliente;
	private String apellidos_cliente;
	@Column(unique=true)
	private int telefono_cliente;
	@Column(unique=true)
	private String correo_electronico;
	private String contrasena;
	@Column(unique=true)
	private int tarjeta_credito;
	
	@OneToMany(mappedBy="cliente")
	private List<Pedidos> listaPedidos;
	
	public Cliente() {}

	public Cliente(String dni_cliente, String nombre_cliente, String apellidos_cliente, int telefono_cliente,
			String correo_electronico, String contrasena, int tarjeta_credito) {
		this.dni_cliente = dni_cliente;
		this.nombre_cliente = nombre_cliente;
		this.apellidos_cliente = apellidos_cliente;
		this.telefono_cliente = telefono_cliente;
		this.correo_electronico = correo_electronico;
		this.contrasena = contrasena;
		this.tarjeta_credito = tarjeta_credito;
	}

	public String getDni_cliente() {
		return dni_cliente;
	}

	public void setDni_cliente(String dni_cliente) {
		this.dni_cliente = dni_cliente;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getApellidos_cliente() {
		return apellidos_cliente;
	}

	public void setApellidos_cliente(String apellidos_cliente) {
		this.apellidos_cliente = apellidos_cliente;
	}

	public int getTelefono_cliente() {
		return telefono_cliente;
	}

	public void setTelefono_cliente(int telefono_cliente) {
		this.telefono_cliente = telefono_cliente;
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

	public int getTarjeta_credito() {
		return tarjeta_credito;
	}

	public void setTarjeta_credito(int tarjeta_credito) {
		this.tarjeta_credito = tarjeta_credito;
	}
	
	
	public List<Pedidos> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedidos> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	@Override
	public String toString() {
		return "Cliente [dni_cliente=" + dni_cliente + ", nombre_cliente=" + nombre_cliente + ", apellidos_cliente="
				+ apellidos_cliente + ", telefono_cliente=" + telefono_cliente + ", correo_electronico="
				+ correo_electronico + ", contrasena=" + contrasena + ", tarjeta_credito=" + tarjeta_credito + "]";
	}
}
