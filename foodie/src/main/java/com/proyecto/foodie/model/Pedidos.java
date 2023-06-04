package com.proyecto.foodie.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Pedidos {
	
	@Id
	private int numero_pedido;
	
	private String direccion_envio;
	private double precio_total;
	private String metodo_pago;
	
	@ManyToOne
	@JoinColumn(name="dni_cliente")
	private Cliente cliente;
	
	@ManyToMany(mappedBy="listaPedidos")
	private List<Platos> listaPlatos;
	
	public Pedidos() {}

	public Pedidos(int numero_pedido, String direccion_envio, double precio_total, String metodo_pago, Cliente cliente) {
		this.numero_pedido = numero_pedido;
		this.direccion_envio = direccion_envio;
		this.precio_total = precio_total;
		this.metodo_pago = metodo_pago;
		this.cliente = cliente;
	}

	public int getNumero_pedido() {
		return numero_pedido;
	}

	public void setNumero_pedido(int numero_pedido) {
		this.numero_pedido = numero_pedido;
	}

	public String getDireccion_envio() {
		return direccion_envio;
	}

	public void setDireccion_envio(String direccion_envio) {
		this.direccion_envio = direccion_envio;
	}

	public double getPrecio_total() {
		return precio_total;
	}

	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}

	public String getMetodo_pago() {
		return metodo_pago;
	}

	public void setMetodo_pago(String metodo_pago) {
		this.metodo_pago = metodo_pago;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Platos> getListaPlatos() {
		return listaPlatos;
	}

	public void setListaPlatos(List<Platos> listaPlatos) {
		this.listaPlatos = listaPlatos;
	}

	@Override
	public String toString() {
		return "Pedidos [numero_pedido=" + numero_pedido + ", direccion_envio=" + direccion_envio + ", precio_total="
				+ precio_total + ", metodo_pago=" + metodo_pago + ", cliente=" + cliente.getDni_cliente() + "]";
	}
}
