package entity;
// Generated 07-jul-2015 11:43:32 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Revisiones generated by hbm2java
 */
public class Revisiones  implements java.io.Serializable {


     private BigDecimal idrevision;
     private Scambio scambio;
     private String observaciones;

    public Revisiones() {
    }

    public Revisiones(BigDecimal idrevision, Scambio scambio, String observaciones) {
       this.idrevision = idrevision;
       this.scambio = scambio;
       this.observaciones = observaciones;
    }
   
    public BigDecimal getIdrevision() {
        return this.idrevision;
    }
    
    public void setIdrevision(BigDecimal idrevision) {
        this.idrevision = idrevision;
    }
    public Scambio getScambio() {
        return this.scambio;
    }
    
    public void setScambio(Scambio scambio) {
        this.scambio = scambio;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }




}


