package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoCompraVenta extends Contrato {
    private Terreno terreno;
    private double impuestos;

   

    public ContratoCompraVenta(String codigo, LocalDate fechaContrato, Cliente cliente, Inmueble inmobiliaria,
			Terreno terreno, double impuestos) {
		super(codigo, fechaContrato, cliente, inmobiliaria);
		this.terreno = terreno;
		this.impuestos = impuestos;
	}

	public double calcularMontoTotal() {
		double total = impuestos+terreno.getPrecio();
		return total;
    }


	public void mostrarDatos() {
		System.out.println("Contrato Compra-Venta [Precio: $" + terreno.getPrecio() +
                ", Impuestos: $" + impuestos + ", Monto Total: $" + calcularMontoTotal() + ", Fecha: " + fechaContrato + "]");
        cliente.mostrarDatos();
        terreno.mostrarDatos();		
	}
}
