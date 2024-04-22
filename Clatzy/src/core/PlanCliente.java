
package core;

import java.time.LocalDate;

public class PlanCliente extends Producto{
    private Cliente cliente;
    private Plan plan;

    public PlanCliente(Cliente cliente, Plan plan, LocalDate fechaInicio) {
        super(fechaInicio);
        this.cliente = cliente;
        this.plan = plan;
        plan.addPlanCliente(this);
    }
    
    public void setEstadoActivo(boolean estado){
        this.estadoActivo = estado;
    }
    
    public float getMax(){
        return plan.getMax();
    }
    
    public boolean getEstado(){
        return this.estadoActivo;
    }
}
