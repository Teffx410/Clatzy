package core;

import java.time.LocalDate;
import java.util.ArrayList;

public class Clatzy {

    private ArrayList<Cliente> clientes;
    private ArrayList<Instructor> instructores;
    private ArrayList<Curso> cursos;
    private ArrayList<Plan> planes;

    public Clatzy() {
        clientes = new ArrayList<>();
        instructores = new ArrayList<>();
        cursos = new ArrayList<>();
        planes = new ArrayList<>();
    }

    public void addInstructor(String nombre, String cedula, String numero, String email) {
        this.instructores.add(new Instructor(nombre, cedula, numero, email));
    }

    public Instructor getInstructor(int index) {
        return this.instructores.get(index);
    }

    public void addCliente(String nombre, String cedula, String numero, String email) {
        this.clientes.add(new Cliente(nombre, cedula, numero, email));
    }

    public Cliente getCliente(int index) {
        return this.clientes.get(index);
    }

    public void addCurso(int id, String nombre, LocalDate date, int valor, Instructor instructor) {
        this.cursos.add(new Curso(id, nombre, date, valor, instructor));
    }

    public Curso getCurso(int index) {
        return this.cursos.get(index);
    }

    public void addPlan(String name, LocalDate date, int valor, float valorMax) {
        this.planes.add(new Plan(name, date, valor, valorMax));
    }

    public Plan getPlan(int index) {
        return this.planes.get(index);
    }

    public void comprarPlan(Cliente cliente, Plan plan, LocalDate date) {
        if (buscarEstado(cliente, plan)) {
            cliente.addPlanCliente(new PlanCliente(cliente, plan, date));
            System.out.println("El cliente " + cliente.getNombre() + " compro exitosamente un plan " + plan.getNombre());
        } else {
            System.out.println("El cliente " + cliente.getNombre() + " ya tiene un plan activo");
        }
    }

    public void comprarCurso(Cliente cliente, Curso curso, LocalDate date) {
        if (cliente.getPlan(0).getMax() >= curso.getValor()) {
            cliente.addProductoCliente(cliente, curso, date);
            System.out.println("El cliente " + cliente.getNombre() + " registro exitosamente el curso " + curso.getNombre());
        } else {
            System.out.println("El plan del cliente " + cliente.getNombre() + " no cubre el curso " + curso.getNombre());
        }
    }

    public void comprarCurso(Cliente cliente, Curso curso, LocalDate date, float valor) {
        //El cliente Miguel Jimenez compro exitosamente el curso Introduccion a programacion movil
        //El cliente Augusto Belalcazar no pago el valor correcto por el curso Introduccion a programacion movil
        if (!cliente.getProductosClientes().contains(curso)) {
            cliente.addProductoCliente(cliente, curso, date, valor);
        } else {
            System.out.println("El cliente " + cliente.getNombre() + " ya habia registrado el curso " + curso.getNombre());
        }
    }

    public void listAll() {
    }

    public String getClienteMayorIngreso() {
        Cliente maxC = this.getCliente(0);
        int maxV = 0;
        for (Cliente cliente : this.clientes) {
            int sum = 0;
            for (ProductoCliente producto : cliente.getProductosClientes()) {
                if (producto.getValor() != 0) {
                    sum += producto.getValor();
                }
            }
            if (sum > maxV) {
                maxV = sum;
                maxC = cliente;
            }
        }
        return maxC.getNombre();
    }

    private boolean buscarEstado(Cliente cliente, Plan plan) {
        try {
            return cliente.getPlan(0).getEstado();
        } catch (Exception e) {

            return false;
        }
    }
}


