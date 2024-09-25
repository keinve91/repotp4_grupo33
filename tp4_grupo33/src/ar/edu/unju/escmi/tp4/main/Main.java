package ar.edu.unju.escmi.tp4.main;

import ar.edu.unju.escmi.tp4.collections.*;
import ar.edu.unju.escmi.tp4.dominio.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1 – Registrar terreno");
            System.out.println("2 – Registrar vivienda");
            System.out.println("3 – Registrar cliente");
            System.out.println("4 – Alquiler de vivienda");
            System.out.println("5 – Venta de terreno");
            System.out.println("6 – Consultar inmuebles disponibles");
            System.out.println("7 – Consultar contratos de alquiler");
            System.out.println("8 – Consultar contratos de venta");
            System.out.println("9 – Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    registrarTerreno(sc);
                    break;
                case 2:
                    registrarVivienda(sc);
                    break;
                case 3:
                    registrarCliente(sc);
                    break;
                case 4:
                    alquilerVivienda(sc);
                    break;
                case 5:
                    ventaTerreno(sc);
                    break;
                case 6:
                    InmuebleCollection.mostrarInmueblesDisponibles();
                    break;
                case 7:
                    ContratoCollection.mostrarContratosAlquiler();
                    break;
                case 8:
                    ContratoCollection.mostrarContratosVenta();
                    break;
                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);
        sc.close();
    }


    public static void registrarTerreno(Scanner sc) {
        System.out.println("Registrar nuevo terreno:");
        System.out.print("Ingrese código: ");
        String codigo = sc.next();
        System.out.print("Ingrese latitud: ");
        double latitud = sc.nextDouble();
        System.out.print("Ingrese longitud: ");
        double longitud = sc.nextDouble();
        System.out.print("Ingrese superficie (en m2): ");
        double superficie = sc.nextDouble();
        System.out.print("Ingrese precio de venta: ");
        double precio = sc.nextDouble();
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponibilidad = sc.nextBoolean();

        Terreno nuevoTerreno = new Terreno(codigo, disponibilidad, latitud, longitud, superficie, precio);
        InmuebleCollection.agregarInmueble(nuevoTerreno);
        System.out.println("Terreno registrado exitosamente.");
    }

    public static void registrarVivienda(Scanner sc) {
        System.out.println("Registrar nueva vivienda:");
        System.out.print("Ingrese código: ");
        String codigo = sc.next();
        sc.nextLine(); 
        System.out.print("Ingrese dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Ingrese cantidad de habitaciones: ");
        int habitaciones = sc.nextInt();
        System.out.print("Ingrese precio de alquiler mensual: ");
        double precioAlquiler = sc.nextDouble();
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponibilidad = sc.nextBoolean();

        Vivienda nuevaVivienda = new Vivienda(codigo, disponibilidad, direccion, habitaciones, precioAlquiler);
        InmuebleCollection.agregarInmueble(nuevaVivienda);
        System.out.println("Vivienda registrada exitosamente.");
    }

    public static void registrarCliente(Scanner sc) {
        System.out.println("Registrar nuevo cliente:");
        System.out.print("Ingrese nombre: ");
        String nombre = sc.next();
        System.out.print("Ingrese apellido: ");
        String apellido = sc.next();
        System.out.print("Ingrese DNI: ");
        String dni = sc.next();
        System.out.print("Ingrese teléfono: ");
        String telefono = sc.next();
        sc.nextLine();
        System.out.print("Ingrese dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Ingrese email: ");
        String email = sc.next();

        Cliente nuevoCliente = new Cliente(nombre, apellido, dni, telefono, direccion, email);
        ClienteCollection.agregarCliente(nuevoCliente);
        System.out.println("Cliente registrado exitosamente.");
    }


    public static void alquilerVivienda(Scanner sc) {
        System.out.println("Alquiler de vivienda:");
        InmuebleCollection.mostrarInmueblesDisponibles();

        System.out.print("Ingrese el código de la vivienda que desea alquilar: ");
        String codigoVivienda = sc.next();

        Vivienda viviendaSeleccionada = null;
        for (Inmueble inmueble : InmuebleCollection.inmuebles) {
            if (inmueble instanceof Vivienda && inmueble.getCodigo().equals(codigoVivienda) && inmueble.estadisponible()) {
                viviendaSeleccionada = (Vivienda) inmueble;
                break;
            }
        }

        if (viviendaSeleccionada == null) {
            System.out.println("No se encontró la vivienda o no está disponible.");
            return;
        }

        registrarCliente(sc); 
        Cliente cliente = ClienteCollection.clientes.get(ClienteCollection.clientes.size() - 1); 

        System.out.print("Ingrese la duración del contrato en meses: ");
        int duracion = sc.nextInt();
        System.out.print("Ingrese los gastos de la inmobiliaria: ");
        double gastosInmobiliaria = sc.nextDouble();

        ContratoAlquiler nuevoContrato = new ContratoAlquiler(duracion, viviendaSeleccionada.getPrecioAlquiler(), gastosInmobiliaria, cliente, viviendaSeleccionada, LocalDate.now());
        ContratoCollection.agregarContratoAlquiler(nuevoContrato);

        viviendaSeleccionada.setestadisponible(false); 
        System.out.println("Contrato de alquiler registrado exitosamente.");
    }

    public static void ventaTerreno(Scanner sc) {
        System.out.println("Venta de terreno:");
        InmuebleCollection.mostrarInmueblesDisponibles();

        System.out.print("Ingrese el código del terreno que desea vender: ");
        String codigoTerreno = sc.next();

        Terreno terrenoSeleccionado = null;
        for (Inmueble inmueble : InmuebleCollection.inmuebles) {
            if (inmueble instanceof Terreno && inmueble.getCodigo().equals(codigoTerreno) && inmueble.estadisponible()) {
                terrenoSeleccionado = (Terreno) inmueble;
                break;
            }
        }

        if (terrenoSeleccionado == null) {
            System.out.println("No se encontró el terreno o no está disponible.");
            return;
        }

        registrarCliente(sc); 
        Cliente cliente = ClienteCollection.clientes.get(ClienteCollection.clientes.size() - 1);

        System.out.print("Ingrese los impuestos de la venta: ");
        double impuestos = sc.nextDouble();

        ContratoCompraVenta nuevoContrato = new ContratoCompraVenta(terrenoSeleccionado, cliente, impuestos, LocalDate.now());
        ContratoCollection.agregarContratoVenta(nuevoContrato);

        terrenoSeleccionado.setestadisponible(false); 
        System.out.println("Contrato de venta registrado exitosamente.");
    }
}
