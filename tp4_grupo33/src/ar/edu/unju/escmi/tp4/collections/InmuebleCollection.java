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
            if (inmueble.isEstado()) {
                inmueble.mostrarDatos();
            }
        }
    }

    public static Inmueble buscarInmueblePorCodigo(String codigo) {
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getCodigo().equals(codigo)) {
                return inmueble;
            }
        }
        return null;
    }
    public static boolean codigoEnUso(String codigo) {
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.getCodigo().equals(codigo)) {
                return true; // El código ya está en uso
            }
        }
        return false; // El código está disponible
    }
}
