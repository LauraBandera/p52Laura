/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author LauraBandera
 */
public class EmpresaAlquilerVehiculos {
// Atributos de la empresa

    private String cif;
    private String nombre;
    private String paginaWeb;
    
    //No son static por cada empresa necesita sus
    // clintes, vehiculos y alquileres si pusiesemos static
    // al ser de clase todas las empresas que creamos compartirían
    // las listas tanto de clietnes, vehiculos y alquileres
    private ArrayList<Cliente> clientes;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<VehiculoAlquilado> alquileres;

    
    EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.clientes = new ArrayList<>(); 
        this.vehiculos = new ArrayList<>();
        this.alquileres = new ArrayList<>();
    }

    public void registrarCliente(Cliente nuevo) {
        this.clientes.add(nuevo);
    }

    private void ordenarPorNif(){
        Comparator<Cliente> criterio = (o1, o2) -> o1.getNif().compareTo(o2.getNif());
        Collections.sort(clientes, criterio);
    }
    
    public int buscarClientePorNIF(Cliente aBuscar) {
        this.ordenarPorNif();
        System.out.println("Hemos ordenado por NIF");
        Comparator<Cliente> criterio = (o1, o2) -> o1.getNif().compareTo(o2.getNif());
        return Collections.binarySearch(clientes, aBuscar, criterio);
    }

    
    public void imprimirClientes() {
        clientes.forEach(item -> System.out.print(item.getNif() + "\t" + item.getNombre()));
    }

    public void registrarVehiculo(Vehiculo nuevo) {
        vehiculos.add(nuevo);
    }

    private void ordenarPorMatricula(){
        Comparator<Vehiculo> criterio = (v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula());
        Collections.sort(vehiculos, criterio);
    }
    
    public int buscarVehiculoPorMatricula(Vehiculo v) {
        this.ordenarPorMatricula();
        System.out.println("Hemos ordenado por matrícula");
        Comparator<Vehiculo> criterio = (v1, v2) -> v1.getMatricula().compareTo(v2.getMatricula());
        return Collections.binarySearch(vehiculos, v, criterio);
    }

    public void imprimirVehiculos() {
        for (Vehiculo v : vehiculos) {
            System.out.println(v);
        }
    }

    public boolean alquilarVehiculo(Cliente c, Vehiculo v, int dias) {
        // busca el cliente a partir del nif
        int cliente = buscarClientePorNIF(c);
        // busca el vehículo a partir de la matrícula
        int vehiculo = buscarVehiculoPorMatricula(v);

        if (cliente < 0 && vehiculo < 0) {
            if (v.isDisponible()) {
                v.setDisponible(false);
                alquileres.add(new VehiculoAlquilado(c, v,
                                LocalDate.now(), dias));
                
                return true; 
            }
        }
        return false; 
    }

    public void recibirVehiculo(Vehiculo v) {

        // busca el vehículo con la matrícula dada en el
        // array vehiculos y modifica su disponibilidad
        // para que se pueda alquilar de nuevo
        int recibir = buscarVehiculoPorMatricula(v);

        if (recibir < 0) {
            v.setDisponible(true);
        }

    }
 

    public void imprimirMatriculaFecha() {
        for (int i = 0; i < alquileres.size(); i++) {
            System.out.println("El vehículo con mátricula " + alquileres.get(i).getVehiculo().getMatricula() +
            		" debe entregarse con fecha de " + entregaVehiculos(alquileres.get(i)));
        }
    }

    //Metodo para averiguar la fecha que hay que devolver el vehiculo
    private LocalDate entregaVehiculos(VehiculoAlquilado v) {
        LocalDate fechaAlquiler = v.getFechaAlquiler().plus(v.getTotalDiasAlquiler(), ChronoUnit.DAYS);
        return fechaAlquiler;
    }

    // incluir métodos ‘get’,‘set’ 
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<VehiculoAlquilado> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(ArrayList<VehiculoAlquilado> alquileres) {
        this.alquileres = alquileres;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.cif);
        hash = 67 * hash + Objects.hashCode(this.nombre);
        hash = 67 * hash + Objects.hashCode(this.paginaWeb);
        hash = 67 * hash + Objects.hashCode(this.clientes);
        hash = 67 * hash + Objects.hashCode(this.vehiculos);
        hash = 67 * hash + Objects.hashCode(this.alquileres);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmpresaAlquilerVehiculos other = (EmpresaAlquilerVehiculos) obj;
        if (!Objects.equals(this.cif, other.cif)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.paginaWeb, other.paginaWeb)) {
            return false;
        }
        if (!Objects.equals(this.clientes, other.clientes)) {
            return false;
        }
        if (!Objects.equals(this.vehiculos, other.vehiculos)) {
            return false;
        }
        if (!Objects.equals(this.alquileres, other.alquileres)) {
            return false;
        }
        return true;
    }
    
    
}
