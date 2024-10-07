package ar.edu.unju.escmi.tp4.collections;

import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;
import ar.edu.unju.escmi.tp4.dominio.ContratoCompraVenta;
import java.util.ArrayList;

public class ContratoCollection {
    public static ArrayList<ContratoAlquiler> contratosAlquiler = new ArrayList<>();
    public static ArrayList<ContratoCompraVenta> contratosVentasTerreno = new ArrayList<>();

    public static void agregarContratoAlquiler(ContratoAlquiler contrato) {
        contratosAlquiler.add(contrato);
    }

    public static void agregarContratoVenta(ContratoCompraVenta contrato) {
        contratosVentasTerreno.add(contrato);
    }

    public static void mostrarContratosAlquiler() {
        for (ContratoAlquiler contrato : contratosAlquiler) {
            contrato.mostrarDatos();
        }
    }

    public static double calcularMontoTotalVentasTerreno() {
        double total = 0;
        for (ContratoCompraVenta contrato : contratosVentasTerreno) {
            total += contrato.calcularMontoTotal();
        }
        return total;
    }
}
