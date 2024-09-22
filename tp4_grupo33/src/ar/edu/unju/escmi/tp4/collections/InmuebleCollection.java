package ar.edu.unju.escmi.tp4.collections;

import ar.edu.unju.escmi.tp4.dominio.Inmueble;
import java.util.ArrayList;

public class InmuebleCollection {
    public static ArrayList<Inmueble> inmuebles = new ArrayList<>();

    public static void agregarInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
    }

    public static void mostrarInmueblesDisponibles() {
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.estadisponible()) {
                inmueble.mostrarDatos(); // Muestra los detalles de los inmuebles disponibles
            }
        }
    }
}
