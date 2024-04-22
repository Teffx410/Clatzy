
package core;

import java.time.LocalDate;
import java.util.ArrayList;


public class Plan extends Producto{
    private float valorMaximoCurso;
    private ArrayList<PlanCliente> planes;

    public Plan( String nombre, LocalDate fechaInicio, float valor, float valorMaximoCurso) {
        super(nombre, fechaInicio, valor);
        this.valorMaximoCurso = valorMaximoCurso;
        planes = new ArrayList<>();
    }

    public void addPlanCliente(PlanCliente planCliente) {
        this.planes.add(planCliente);
    } 
    
    public float getMax(){
        return this.valorMaximoCurso;
    }
    
    public String getNombre(){
        return this.nombre;
    }
}
