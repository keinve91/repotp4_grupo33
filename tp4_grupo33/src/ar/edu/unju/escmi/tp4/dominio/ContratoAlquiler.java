package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoAlquiler {
    private int duracion;
    private double precio;
    private double gastosInmobiliaria;
    private Cliente cliente;
    private Vivienda vivienda;
    private LocalDate fechaContrato;

    public ContratoAlquiler(int duracion, double precio, double gastosInmobiliaria, Cliente cliente, Vivienda vivienda, LocalDate fechaContrato) {
        this.duracion = duracion;
        this.precio = precio;
        this.gastosInmobiliaria = gastosInmobiliaria;
        this.cliente = cliente;
        this.vivienda = vivienda;
        this.fechaContrato = fechaContrato;
    }

    public double calcularMontoTotal() {
        return precio + gastosInmobiliaria;
    }

    public void mostrarDatosContrato() {
        System.out.println("Contrato Alquiler [Duración: " + duracion + " meses, Precio: $" + precio +
                ", Gastos Inmobiliaria: $" + gastosInmobiliaria + ", Monto Total: $" + calcularMontoTotal() +
                ", Fecha: " + fechaContrato + "]");
        cliente.mostrarDatos();
        vivienda.mostrarDatos();
    }
}
