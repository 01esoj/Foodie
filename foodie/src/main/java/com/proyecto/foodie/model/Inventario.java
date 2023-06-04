package com.proyecto.foodie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Inventario {
	
	@Id
	private int id_ingrediente;
	
	private double cantidad;
	private double preico_compra;
	private String proveedor;
	
	@OneToMany(mappedBy="inventario")
	private List<Ingredientes> listaIngredientes;
	
	public Inventario() {}

	public Inventario(int id_ingrediente, double cantidad, double preico_compra, String proveedor) {
		this.id_ingrediente = id_ingrediente;
		this.cantidad = cantidad;
		this.preico_compra = preico_compra;
		this.proveedor = proveedor;
	}

	public int getId_ingrediente() {
		return id_ingrediente;
	}

	public void setId_ingrediente(int id_ingrediente) {
		this.id_ingrediente = id_ingrediente;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPreico_compra() {
		return preico_compra;
	}

	public void setPreico_compra(double preico_compra) {
		this.preico_compra = preico_compra;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public List<Ingredientes> getListaIngredientes() {
		return listaIngredientes;
	}

	public void setListaIngredientes(List<Ingredientes> listaIngredientes) {
		this.listaIngredientes = listaIngredientes;
	}

	@Override
	public String toString() {
		return "Inventario [id_ingrediente=" + id_ingrediente + ", cantidad=" + cantidad + ", preico_compra="
				+ preico_compra + ", proveedor=" + proveedor + "]";
	}
}
