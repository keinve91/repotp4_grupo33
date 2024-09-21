package ar.edu.unju.escmi.tp4.dominio;

public class Vivienda extends Inmueble {
    private String direccion;
    private int cantidadHabitaciones;
    private double precioAlquiler;

    public Vivienda(String codigo, boolean disponibilidad, String direccion, int cantidadHabitaciones, double precioAlquiler) {
        super(codigo, disponibilidad);
        this.direccion = direccion;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.precioAlquiler = precioAlquiler;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Vivienda [Código: " + codigo + ", Dirección: " + direccion +
                ", Habitaciones: " + cantidadHabitaciones + ", Precio Alquiler: $" + precioAlquiler +
                ", Disponible: " + estadisponible() + "]");
    }


    public double getPrecioAlquiler() {
        return precioAlquiler;
    }
}
