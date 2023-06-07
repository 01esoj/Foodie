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
	private int idPlato;
	
	private String nombrePlato;
	private double precioPlato;
	private String categoria;
	private String descripcion;
	
	@JoinTable(
			name="rel_platos_pedidos", 
			joinColumns = @JoinColumn(name="idPlato", nullable=false), 
			inverseJoinColumns = @JoinColumn(name="numeroPedido", nullable = false))
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Pedidos> listaPedidos;
	
	@JoinTable(
			name="rel_platos_usuarios", 
			joinColumns = @JoinColumn(name="idPlato", nullable=false), 
			inverseJoinColumns = @JoinColumn(name="dniUsuario", nullable = false))
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Usuarios> listaUsuarios;
	
	@JoinTable(
			name="rel_platos_ingredientes", 
			joinColumns = @JoinColumn(name="idPlato", nullable=false), 
			inverseJoinColumns = @JoinColumn(name="idIngrediente", nullable = false))
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Ingredientes> listaIngredientes;
	
	public Platos() {}
	
	public Platos(int idPlato, String nombrePlato, double precioPlato, String categoria, String descripcion) {
		this.idPlato = idPlato;
		this.nombrePlato = nombrePlato;
		this.precioPlato = precioPlato;
		this.categoria = categoria;
		this.descripcion = descripcion;
	}

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public void setNombrePlato(String nombrePlato) {
		this.nombrePlato = nombrePlato;
	}

	public double getPrecioPlato() {
		return precioPlato;
	}

	public void setPrecioPlato(double precioPlato) {
		this.precioPlato = precioPlato;
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
		return "Platos [idPlato=" + idPlato + ", nombrePlato=" + nombrePlato + ", precioPlato=" + precioPlato
				+ ", categoria=" + categoria + ", descripcion=" + descripcion + "]";
	}
}
