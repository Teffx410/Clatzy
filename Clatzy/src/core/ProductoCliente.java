package core;

import java.time.LocalDate;

public class ProductoCliente extends Producto {

    private boolean estadoAprobado;
    private int nivelAvance;
    private Cliente cliente;
    private Curso curso;

    public ProductoCliente(Cliente cliente, Curso curso, int id, String nombre, LocalDate fechaInicio) {
        super(id, nombre, fechaInicio);
        this.cliente = cliente;
        this.curso = curso;
        if (cliente.getPlan(0).getMax() == curso.getValor()) {
            this.estadoAprobado = true;
            this.valor = 0;
        } else {
            this.estadoAprobado = false;
        }
    }

    public ProductoCliente(Cliente cliente, Curso curso, int id, String nombre, LocalDate fechaInicio, float valor) {
        super(id, nombre, fechaInicio);
        this.cliente = cliente;
        this.curso = curso;
        if (valor == curso.getValor()) {
            this.estadoAprobado = true;
            this.valor = valor;
            System.out.println("El cliente " + cliente.getNombre() + " compro exitosamente el curso " + curso.getNombre());
        } else {
            this.estadoAprobado = false;
            System.out.println("El cliente " + cliente.getNombre() + " no pago el valor correcto por el curso " + curso.getNombre());

        }
    }
    
    public float getValor(){
        return this.valor;
    }
}
