package ar.edu.unju.escmi.tp4.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp4.dominio.*;

public class ContratoCollection { 
	
	public static List<ContratoCompraVenta> contratosCVT = new ArrayList<>();
	
	public static void agregarContratoCVT(ContratoCompraVenta contratoCVT) {
		contratosCVT.add(contratoCVT);
	}
	
	public static List<ContratoAlquiler> contratos = new ArrayList<>();

    public static void agregarContrato(ContratoAlquiler contrato) {
        contratos.add(contrato);
    }

	
}