package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoAlquiler extends Contrato {
    private double duracion;
    private double gastosInmpuestos;
    private Vivienda vivienda;

    public ContratoAlquiler(String codigo, LocalDate fechaContrato, Cliente cliente, Inmueble inmobiliaria,
                            double duracion, double gastosInmpuestos, Vivienda vivienda) {
        super(codigo, fechaContrato, cliente, inmobiliaria);
        this.duracion = duracion;
        this.gastosInmpuestos = gastosInmpuestos;
        this.vivienda = vivienda;
    }

    public double calcularMontoTotal() {
        return vivienda.getPrecio() + gastosInmpuestos;
    }

    public void mostrarDatos() {
        System.out.println("Duracion: " + duracion);
        System.out.println("Precio: " + vivienda.getPrecio());
        System.out.println("Gastos de inmobiliaria: " + gastosInmpuestos);
        System.out.println("Dueño: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Direccion: " + vivienda.getDireccion());
        System.out.println("Monto Total: " + calcularMontoTotal());
        System.out.println("***********************************************************");
    }

	

}
