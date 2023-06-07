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
	private int idIngrediente;
	
	private String nombreIngrediente;
	private double precioUnitario;
	
	@ManyToOne
	@JoinColumn(name="idIngrediente", insertable = false, updatable = false)
	private Inventario inventario;
	
	@ManyToMany(mappedBy="listaIngredientes")
	private List<Platos> listaPlatos;
	
	public Ingredientes() {}

	public Ingredientes(int idIngrediente, String nombreIngrediente, double precioUnitario) {
		this.idIngrediente = idIngrediente;
		this.nombreIngrediente = nombreIngrediente;
		this.precioUnitario = precioUnitario;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombreIngrediente() {
		return nombreIngrediente;
	}

	public void setNombreIngrediente(String nombreIngrediente) {
		this.nombreIngrediente = nombreIngrediente;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
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
		return "Ingredientes [idIngrediente=" + idIngrediente + ", nombreIngrediente=" + nombreIngrediente
				+ ", precioUnitario=" + precioUnitario + "]";
	}
}
