
package core;

import java.time.LocalDate;
import java.util.ArrayList;


public class Curso extends Producto {
    private ArrayList<Instructor> instructores;
    private ArrayList<ProductoCliente> productosClientes;

    public Curso(int id, String nombre, LocalDate fechaInicio, float valor, Instructor instructor) {
        super(id, nombre, fechaInicio, valor);        
        productosClientes = new ArrayList<>();
        instructores = new ArrayList<>();
        instructores.add(instructor);
        instructor.addCurso(this);
    }
    
    public void addProductoCliente (ProductoCliente productoCliente){
        this.productosClientes.add(productoCliente);
    }
    
    public int getId(){
        return this.id;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public float getValor(){
        return this.valor;
    }
}
