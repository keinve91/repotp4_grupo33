package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoCompraVenta {
    private Terreno terreno;
    private Cliente cliente;
    private double impuestos;
    private LocalDate fechaContrato;

    public ContratoCompraVenta(Terreno terreno, Cliente cliente, double impuestos, LocalDate fechaContrato) {
        this.terreno = terreno;
        this.cliente = cliente;
        this.impuestos = impuestos;
        this.fechaContrato = fechaContrato;
    }

    public double calcularMontoTotal() {
        return terreno.getPrecio() + impuestos;
    }

    public void mostrarDatosContrato() {
        System.out.println("Contrato Compra-Venta [Precio: $" + terreno.getPrecio() +
                ", Impuestos: $" + impuestos + ", Monto Total: $" + calcularMontoTotal() + ", Fecha: " + fechaContrato + "]");
        cliente.mostrarDatos();
        terreno.mostrarDatos();
    }
}
