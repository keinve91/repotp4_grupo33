package ar.edu.unju.escmi.tp4.main;

import ar.edu.unju.escmi.tp4.dominio.*;
import ar.edu.unju.escmi.tp4.collections.*;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de Opciones:");
            System.out.println("1 - Registrar terreno");
            System.out.println("2 - Registrar vivienda");
            System.out.println("3 - Registrar cliente");
            System.out.println("4 - Alquiler de vivienda");
            System.out.println("5 - Venta de terreno");
            System.out.println("6 - Consultar inmuebles (1 - Viviendas, 2 - Terrenos)");
            System.out.println("7 - Consultar viviendas alquiladas");
            System.out.println("8 - Consultar terrenos vendidos");
            System.out.println("9 - Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
            case 1: 
                String codigoTerreno;
                do {
                    System.out.print("Ingrese código del terreno: ");
                    codigoTerreno = scanner.next();
                    if (InmuebleCollection.codigoEnUso(codigoTerreno)) {
                        System.out.println("Código ya utilizado. Ingrese otro.");
                    }
                } while (InmuebleCollection.codigoEnUso(codigoTerreno));
                
                System.out.print("Ingrese precio: ");
                double precioTerreno = scanner.nextDouble();
                System.out.print("Ingrese latitud: ");
                double latitud = scanner.nextDouble();
                System.out.print("Ingrese longitud: ");
                double longitud = scanner.nextDouble();
                System.out.print("Ingrese superficie: ");
                double superficie = scanner.nextDouble();
                
                Terreno terreno = new Terreno(codigoTerreno, precioTerreno, latitud, longitud, superficie, true);
                InmuebleCollection.agregarInmueble(terreno);
                break;

            case 2: 
                String codigoVivienda;
                do {
                    System.out.print("Ingrese código de la vivienda: ");
                    codigoVivienda = scanner.next();
                    if (InmuebleCollection.codigoEnUso(codigoVivienda)) {
                        System.out.println("Código ya utilizado. Ingrese otro.");
                    }
                } while (InmuebleCollection.codigoEnUso(codigoVivienda));
                
                System.out.print("Ingrese precio de alquiler: ");
                double precioAlquiler = scanner.nextDouble();
                System.out.print("Ingrese dirección: ");
                String direccion = scanner.next();
                System.out.print("Ingrese cantidad de habitaciones: ");
                int cantidadHabitaciones = scanner.nextInt();
                
                Vivienda vivienda = new Vivienda(codigoVivienda, precioAlquiler, direccion, cantidadHabitaciones, true);
               InmuebleCollection.agregarInmueble(vivienda);
                break;

            

                case 3: 
                    System.out.print("Ingrese nombre del cliente: ");
                    String nombre = scanner.next();
                    System.out.print("Ingrese apellido del cliente: ");
                    String apellido = scanner.next();
                    System.out.print("Ingrese DNI del cliente: ");
                    String dni = scanner.next();
                    System.out.print("Ingrese teléfono del cliente: ");
                    String telefono = scanner.next();
                    System.out.print("Ingrese dirección del cliente: ");
                    String direccionCliente = scanner.next();
                    System.out.print("Ingrese email del cliente: ");
                    String email = scanner.next();
                    Cliente cliente = new Cliente(nombre, apellido, dni, telefono, direccionCliente, email);
                    ClienteCollection.agregarCliente(cliente);
                    break;

                case 4: 
                    System.out.print("Ingrese DNI del cliente: ");
                    String dniClienteAlquiler = scanner.next();
                    Cliente clienteAlquiler = ClienteCollection.buscarClientePorDni(dniClienteAlquiler);
                    if (clienteAlquiler != null) {
                        System.out.println("Viviendas disponibles para alquiler:");
                        boolean hayViviendasDisponibles = false;
                        for (Inmueble inmueble : InmuebleCollection.inmuebles) {
                            if (inmueble instanceof Vivienda && inmueble.isEstado()) {
                                inmueble.mostrarDatos();
                                hayViviendasDisponibles = true; // Hay al menos una vivienda disponible
                            }
                        }
                        if (!hayViviendasDisponibles) {
                            System.out.println("No hay viviendas disponibles para alquilar.");
                        } else {
                            System.out.print("Ingrese código de la vivienda a alquilar: ");
                            String codigoAlquilar = scanner.next();
                            Inmueble inmuebleAlquilar = InmuebleCollection.buscarInmueblePorCodigo(codigoAlquilar);
                            if (inmuebleAlquilar instanceof Vivienda && inmuebleAlquilar.isEstado()) {
                                System.out.print("Ingrese duración: ");
                                double duracion = scanner.nextDouble();
                                System.out.print("Ingrese gastos de inmobiliaria: ");
                                double gastosInmpuestos = scanner.nextDouble();
                                ContratoAlquiler contratoAlquiler = new ContratoAlquiler("CA001", LocalDate.now(), clienteAlquiler, inmuebleAlquilar, duracion, gastosInmpuestos, (Vivienda) inmuebleAlquilar);
                                ContratoCollection.agregarContratoAlquiler(contratoAlquiler);
                                inmuebleAlquilar.setEstado(false); // Marcar como no disponible
                                System.out.println("Contrato de alquiler registrado con éxito.");
                            } else {
                                System.out.println("La vivienda no está disponible.");
                            }
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                case 5: 
                    System.out.print("Ingrese DNI del cliente: ");
                    String dniClienteVenta = scanner.next();
                    Cliente clienteVenta = ClienteCollection.buscarClientePorDni(dniClienteVenta);
                    if (clienteVenta != null) {
                        System.out.println("Terrenos disponibles para la venta:");
                        boolean hayTerrenosDisponibles = false;
                        for (Inmueble inmueble : InmuebleCollection.inmuebles) {
                            if (inmueble instanceof Terreno && inmueble.isEstado()) {
                                inmueble.mostrarDatos();
                                hayTerrenosDisponibles = true; // Hay al menos un terreno disponible
                            }
                        }
                        if (!hayTerrenosDisponibles) {
                            System.out.println("No hay terrenos disponibles para la venta.");
                        } else {
                            System.out.print("Ingrese código del terreno a vender: ");
                            String codigoTerrenoVenta = scanner.next();
                            Inmueble inmuebleVenta = InmuebleCollection.buscarInmueblePorCodigo(codigoTerrenoVenta);
                            if (inmuebleVenta instanceof Terreno && inmuebleVenta.isEstado()) {
                                System.out.print("Ingrese impuestos: ");
                                double impuestos = scanner.nextDouble();
                                ContratoCompraVenta contratoVenta = new ContratoCompraVenta("CV001", LocalDate.now(), clienteVenta, inmuebleVenta, (Terreno) inmuebleVenta, impuestos);
                                ContratoCollection.agregarContratoVenta(contratoVenta);
                                inmuebleVenta.setEstado(false); 
                                System.out.println("Contrato de venta registrado con éxito.");
                            } else {
                                System.out.println("El terreno no está disponible.");
                            }
                        }
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;



                case 6: 
                    System.out.println("¿Qué desea ver?");
                    System.out.println("1 - Viviendas");
                    System.out.println("2 - Terrenos");
                    int tipoInmueble = scanner.nextInt();
                    if (tipoInmueble == 1) {
                        System.out.println("Viviendas disponibles:");
                        for (Inmueble inmueble : InmuebleCollection.inmuebles) {
                            if (inmueble instanceof Vivienda && inmueble.isEstado()) {
                                inmueble.mostrarDatos();
                            }
                        }
                    } else if (tipoInmueble == 2) {
                        System.out.println("Terrenos disponibles:");
                        for (Inmueble inmueble : InmuebleCollection.inmuebles) {
                            if (inmueble instanceof Terreno && inmueble.isEstado()) {
                                inmueble.mostrarDatos();
                            }
                        }
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 7: 
                    System.out.println("Viviendas alquiladas:");
                    if (ContratoCollection.contratosAlquiler.isEmpty()) {
                        System.out.println("No hay viviendas alquiladas.");
                    } else {
                        System.out.println("Cantidad de viviendas alquiladas: " + ContratoCollection.contratosAlquiler.size());
                        System.out.println("***********************************************************");
                        for (int i = 0; i < ContratoCollection.contratosAlquiler.size(); i++) {
                            ContratoAlquiler contrato = ContratoCollection.contratosAlquiler.get(i);
                            System.out.println("Vivienda " + (i + 1) + ":");
                            contrato.mostrarDatos();
                        }
                    }
                    break;

                case 8: 
                    double montoTotalVentas = ContratoCollection.calcularMontoTotalVentasTerreno();
                    System.out.println("El monto total de las ventas de terrenos es: $" + montoTotalVentas);
                    break;

                case 9:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}
