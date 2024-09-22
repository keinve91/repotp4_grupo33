package ar.edu.unju.escmi.tp4.collections;

import ar.edu.unju.escmi.tp4.dominio.Cliente;
import java.util.ArrayList;

public class ClienteCollection {
    public static ArrayList<Cliente> clientes = new ArrayList<>();

    public static void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static void mostrarClientes() {
        for (Cliente cliente : clientes) {
            cliente.mostrarDatos(); // Muestra los detalles de los clientes
        }
    }
}
