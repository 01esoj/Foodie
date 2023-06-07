package com.proyecto.foodie.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Inventario {
	
	@Id
	private int idIngrediente;
	
	private double cantidad;
	private double precioCompra;
	private String proveedor;
	
	@OneToMany(mappedBy="inventario")
	private List<Ingredientes> listaIngredientes;
	
	public Inventario() {}

	public Inventario(int idIngrediente, double cantidad, double precioCompra, String proveedor) {
		this.idIngrediente = idIngrediente;
		this.cantidad = cantidad;
		this.precioCompra = precioCompra;
		this.proveedor = proveedor;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
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
		return "Inventario [idIngrediente=" + idIngrediente + ", cantidad=" + cantidad + ", precioCompra="
				+ precioCompra + ", proveedor=" + proveedor + "]";
	}
}
