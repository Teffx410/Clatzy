package core;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Persona {

    private ArrayList<PlanCliente> planes;
    private ArrayList<ProductoCliente> productos;

    public Cliente(String nombre, String cedula, String telefono, String email) {
        super(nombre, cedula, telefono, email);
        productos = new ArrayList<>();
        planes = new ArrayList<>();
    }

    public void addPlanCliente(PlanCliente planCliente) {
        this.planes.add(planCliente);
    }

    public PlanCliente getPlan(int index) {
        return this.planes.get(index);
    }

    public ArrayList<PlanCliente> getPlanes() {
        return this.planes;
    }

    public String getNombre() {
        return this.nombre;
    }

    public ArrayList<ProductoCliente> getProductosClientes() {
        return this.productos;
    }

    void addProductoCliente(Cliente cliente, Curso curso, LocalDate date) {
        this.productos.add(new ProductoCliente(cliente, curso, curso.getId(), curso.getNombre(), date));
    }

    void addProductoCliente(Cliente cliente, Curso curso, LocalDate date, float valor) {
        this.productos.add(new ProductoCliente(cliente, curso, curso.getId(), curso.getNombre(), date, valor));
    }

}
