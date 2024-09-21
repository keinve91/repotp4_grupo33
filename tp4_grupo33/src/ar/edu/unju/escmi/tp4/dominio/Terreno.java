package ar.edu.unju.escmi.tp4.dominio;

public class Terreno extends Inmueble {
    private double latitud;
    private double longitud;
    private double superficie;
    private double precio;

    public Terreno(String codigo, boolean disponibilidad, double latitud, double longitud, double superficie, double precio) {
        super(codigo, disponibilidad);
        this.latitud = latitud;
        this.longitud = longitud;
        this.superficie = superficie;
        this.precio = precio;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Terreno [Código: " + codigo + ", Latitud: " + latitud + ", Longitud: " + longitud +
                ", Superficie: " + superficie + " m2, Precio: $" + precio + ", Disponible: " + estadisponible() + "]");
    }

    public double getPrecio() {
        return precio;
    }
}
