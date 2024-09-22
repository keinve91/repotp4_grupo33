package ar.edu.unju.escmi.tp4.collections;

import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;
import ar.edu.unju.escmi.tp4.dominio.ContratoCompraVenta;
import java.util.ArrayList;

public class ContratoCollection {
    public static ArrayList<ContratoAlquiler> contratosAlquiler = new ArrayList<>();
    public static ArrayList<ContratoCompraVenta> contratosVenta = new ArrayList<>();

    public static void agregarContratoAlquiler(ContratoAlquiler contrato) {
        contratosAlquiler.add(contrato);
    }

    public static void agregarContratoVenta(ContratoCompraVenta contrato) {
        contratosVenta.add(contrato);
    }

    public static void mostrarContratosAlquiler() {
        for (ContratoAlquiler contrato : contratosAlquiler) {
            contrato.mostrarDatosContrato(); // Muestra los detalles de los contratos de alquiler
        }
    }

    public static void mostrarContratosVenta() {
        for (ContratoCompraVenta contrato : contratosVenta) {
            contrato.mostrarDatosContrato(); // Muestra los detalles de los contratos de venta
        }
    }
}
