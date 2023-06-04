package com.proyecto.foodie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Ingredientes {
	
	@Id
	private int id_ingrediente;
	
	private String nombre_ingrediente;
	private double precio_unitario;
	
	@ManyToOne
	@JoinColumn(name="id_ingrediente", insertable = false, updatable = false)
	private Inventario inventario;
	
	@ManyToMany(mappedBy="listaIngredientes")
	private List<Platos> listaPlatos;
	
	public Ingredientes() {}

	public Ingredientes(int id_ingrediente, String nombre_ingrediente, double precio_unitario) {
		this.id_ingrediente = id_ingrediente;
		this.nombre_ingrediente = nombre_ingrediente;
		this.precio_unitario = precio_unitario;
	}

	public int getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(int id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public String getNombre_ingrediente() {
		return nombre_ingrediente;
	}

	public void setNombre_ingrediente(String nombre_ingrediente) {
		this.nombre_ingrediente = nombre_ingrediente;
	}

	public double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}
	
	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public List<Platos> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(List<Platos> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

	@Override
	public String toString() {
		return "Ingredientes [id_ingrediente=" + id_ingrediente + ", nombre_ingrediente=" + nombre_ingrediente
				+ ", precio_unitario=" + precio_unitario + "]";
	}
}
