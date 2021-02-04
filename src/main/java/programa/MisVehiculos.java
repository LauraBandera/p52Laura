/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author LauraBandera
 */
public class MisVehiculos {

    public static void main(String[] args) {

        // la instancia easydrive de la clase EmpresaAlquilerVehiculos
        EmpresaAlquilerVehiculos easydrive
                = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive", "www.easydrive.com");

        // registro de los clientes de la empresa
        easydrive.registrarCliente(new Cliente("X5618927C",
                "Juan", "González López"));
        easydrive.registrarCliente(new Cliente("X5613927C",
                "Pepe", "González Romero"));
        easydrive.registrarCliente(new Cliente("X5618967C",
                "Pedro", "García Fernández"));
        easydrive.registrarCliente(new Cliente("P6618927C",
                "Javier", "Gomez Cabrera"));
        easydrive.registrarCliente(new Cliente("Z7568991Y",
                "Luis", "Fernández Gómez"));
        
        // registro de los vehículos de la empresa 
        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda",
                "Fabia", "Blanco", 90.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang",
                "Rojo", 150.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI",
                "Azul", 110.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza",
                "Blanco", 90.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato",
                "Azul", 80.0, true));
        
        System.out.println("--------- Listado de Vehículos ----------");
        easydrive.imprimirVehiculos();
        System.out.println("--------- Listado de Clientes ----------");
        easydrive.imprimirClientes();
        System.out.println("--------- Listado de Alquileres ----------");
        easydrive.imprimirAlquileres();
        System.out.println("-------- Listado de Alquileres finalizados -----------");
        easydrive.imprimirAlquileresFinalizado();
        System.out.println("-------------------");
        //Añadimos 5 alquileres.
        easydrive.alquilarVehiculo(new Cliente("X5618927C",
                "Juan", "González López"), new Vehiculo("4060 TUR", "Skoda",
                "Fabia", "Blanco", 90.0, false), 2, LocalDate.of(2021, Month.MARCH, 8));
        easydrive.alquilarVehiculo(new Cliente("X5613927C",
                "Pepe", "González Romero"), new Vehiculo("4070 DEP", "Ford", "Mustang",
                "Rojo", 150.0, true), 10, LocalDate.of(2021, Month.FEBRUARY, 6));
        easydrive.alquilarVehiculo(new Cliente("P6618927C",
                "Javier", "Gomez Cabrera"), new Vehiculo("4100 FUR", "Fiat", "Ducato",
                "Azul", 80.0, true), 1, LocalDate.of(2021, Month.FEBRUARY, 9));
        easydrive.alquilarVehiculo(new Cliente("X5613927C",
                "Pepe", "González Romero"), new Vehiculo("4070 DEP", "Ford", "Mustang",
                "Rojo", 150.0, true), 10, LocalDate.of(2021, Month.FEBRUARY, 6));
        easydrive.alquilarVehiculo(new Cliente("P6618927C",
                "Javier", "Gomez Cabrera"), new Vehiculo("4080 TUR", "VW", "GTI",
                "Azul", 110.0, true), 1, LocalDate.of(2021, Month.FEBRUARY, 9));
        System.out.println("--------- Listado de Alquileres ----------");
        easydrive.imprimirAlquileres();
        System.out.println("-------------------");
        easydrive.ordenarPorTarifa();
        System.out.println("--------- Listado de Vehículos ----------");
        easydrive.imprimirVehiculos();
        System.out.println("-------------------");
        easydrive.ordenarAlquilerFecha();
        System.out.println("--------- Listado de Alquileres ----------");
        easydrive.imprimirAlquileres();
        ArrayList <VehiculoAlquilado> listadoJavier = easydrive.busquedaAlquileresClientesNIF(new Cliente("P6618927C",
                "Javier", "Gomez Cabrera"));
        System.out.println("------------- Listado de Alquileres Javier ----------");
        listadoJavier.forEach(item -> System.out.print(item.getVehiculo().toString() + "\n"));
        
        //Finalización de alquileres
        easydrive.finalizarAlquiler(new VehiculoAlquilado(new Cliente("X5618927C",
                "Juan", "González López"), new Vehiculo("4060 TUR", "Skoda",
                "Fabia", "Blanco", 90.0, false), LocalDate.of(2021, Month.MARCH, 8), 2));
        easydrive.finalizarAlquiler(new VehiculoAlquilado(new Cliente("P6618927C",
                "Javier", "Gomez Cabrera"), new Vehiculo("4100 FUR", "Fiat", "Ducato",
                "Azul", 80.0, true), LocalDate.of(2021, Month.FEBRUARY, 9), 1));
        easydrive.finalizarAlquiler(new VehiculoAlquilado(new Cliente("P6618927C",
                "Javier", "Gomez Cabrera"), new Vehiculo("4080 TUR", "VW", "GTI",
                "Azul", 110.0, true), LocalDate.of(2021, Month.FEBRUARY, 9), 1));
        System.out.println("--------- Listado de Alquileres Finalizados ----------");
        easydrive.imprimirAlquileresFinalizado();
        
        /*
        easydrive.imprimirVehiculos();
        System.out.println("-------------------");

        easydrive.alquilarVehiculo(new Cliente("X5618927C",
                "Juan", "González López"), new Vehiculo("4060 TUR", "Skoda",
                "Fabia", "Blanco", 90.0, false), 2, LocalDate.of(2021, Month.MARCH, 8));

        System.out.println("-------------------");
        easydrive.imprimirVehiculos();
        System.out.println("-------------------");

        int pos = easydrive.buscarVehiculoPorMatricula(new Vehiculo("4060 TUR", "Skoda",
                "Fabia", "Blanco", 90.0, false));

        System.out.println("-------------------");
        easydrive.imprimirVehiculos();

        System.out.println(easydrive.getVehiculos().get(pos).isDisponible());

        */
    }
}
