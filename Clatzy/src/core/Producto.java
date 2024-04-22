
package core;

import java.time.LocalDate;


public abstract class Producto {
    protected int id;
    protected String nombre;
    protected LocalDate fechaInicio;
    protected LocalDate fechaFin;
    protected boolean estadoActivo;
    protected float valor;

    public Producto(int id, String nombre, LocalDate fechaInicio, float valor) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.valor = valor;
    }

    public Producto(String nombre, LocalDate fechaInicio, float valor) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.valor = valor;
    }

    public Producto(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
        this.estadoActivo = true;
    }

    public Producto(int id, String nombre, LocalDate fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
    }
    
    
    
    
    
}
