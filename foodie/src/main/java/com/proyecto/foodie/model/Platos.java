package com.proyecto.foodie.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Platos {
	
	@Id
	private int id_plato;
	
	private String nombre_plato;
	private double precio_plato;
	private String categoria;
	private String descripcion;
	
	@JoinTable(
			name="rel_platos_pedidos", 
			joinColumns = @JoinColumn(name="id_plato", nullable=false), 
			inverseJoinColumns = @JoinColumn(name="numero_pedido", nullable = false))
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Pedidos> listaPedidos;
	
	@JoinTable(
			name="rel_platos_usuarios", 
			joinColumns = @JoinColumn(name="id_plato", nullable=false), 
			inverseJoinColumns = @JoinColumn(name="dni_usuario", nullable = false))
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Usuarios> listaUsuarios;
	
	@JoinTable(
			name="rel_platos_ingredientes", 
			joinColumns = @JoinColumn(name="id_plato", nullable=false), 
			inverseJoinColumns = @JoinColumn(name="id_ingrediente", nullable = false))
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Ingredientes> listaIngredientes;
	
	public Platos() {}
	
	public Platos(int id_plato, String nombre_plato, double precio_plato, String categoria, String descripcion) {
		this.id_plato = id_plato;
		this.nombre_plato = nombre_plato;
		this.precio_plato = precio_plato;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}

	public int getId_plato() {
		return id_plato;
	}

	public void setId_plato(int id_plato) {
		this.id_plato = id_plato;
	}

	public String getNombre_plato() {
		return nombre_plato;
	}

	public void setNombre_plato(String nombre_plato) {
		this.nombre_plato = nombre_plato;
	}

	public double getPrecio_plato() {
		return precio_plato;
	}

	public void setPrecio_plato(double precio_plato) {
		this.precio_plato = precio_plato;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Pedidos> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedidos> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<Usuarios> getListaUsuarios() {
		return listaUsuarios;
	}

	public void setListaUsuarios(List<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}

	public List<Ingredientes> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<Ingredientes> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	@Override
	public String toString() {
		return "Platos [id_plato=" + id_plato + ", nombre_plato=" + nombre_plato + ", precio_plato=" + precio_plato
				+ ", categoria=" + categoria + ", descripcion=" + descripcion + "]";
	}
}
