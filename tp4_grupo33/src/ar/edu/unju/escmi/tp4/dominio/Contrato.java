package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public abstract class Contrato {

	protected String codigo; 
	protected LocalDate fechaContrato;
	protected Cliente cliente;
	protected Inmueble inmobiliaria;
	
	public Contrato(String codigo, LocalDate fechaContrato, Cliente cliente, Inmueble inmobiliaria) {
		super();
		this.fechaContrato = fechaContrato;
		this.cliente = cliente;
		this.inmobiliaria = inmobiliaria;
		this.codigo = codigo;
	} 

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public LocalDate getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(LocalDate fechaContrato) {
		this.fechaContrato = fechaContrato;
	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Inmueble getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmueble inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}


	public abstract void mostrarDatos(); 
	
}