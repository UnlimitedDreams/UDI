package entity;
// Generated 07-jul-2015 11:43:32 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Persona generated by hbm2java
 */
public class Persona  implements java.io.Serializable {


     private BigDecimal idpersona;
     private String pnmbre;
     private String snombre;
     private String papellido;
     private String sapellido;
     private Set<Correos> correoses = new HashSet<Correos>(0);
     private Set<Telefonos> telefonoses = new HashSet<Telefonos>(0);
     private Set<Usuarios> usuarioses = new HashSet<Usuarios>(0);

    public Persona() {
    }

	
    public Persona(BigDecimal idpersona, String pnmbre, String papellido) {
        this.idpersona = idpersona;
        this.pnmbre = pnmbre;
        this.papellido = papellido;
    }
    public Persona(BigDecimal idpersona, String pnmbre, String snombre, String papellido, String sapellido, Set<Correos> correoses, Set<Telefonos> telefonoses, Set<Usuarios> usuarioses) {
       this.idpersona = idpersona;
       this.pnmbre = pnmbre;
       this.snombre = snombre;
       this.papellido = papellido;
       this.sapellido = sapellido;
       this.correoses = correoses;
       this.telefonoses = telefonoses;
       this.usuarioses = usuarioses;
    }
   
    public BigDecimal getIdpersona() {
        return this.idpersona;
    }
    
    public void setIdpersona(BigDecimal idpersona) {
        this.idpersona = idpersona;
    }
    public String getPnmbre() {
        return this.pnmbre;
    }
    
    public void setPnmbre(String pnmbre) {
        this.pnmbre = pnmbre;
    }
    public String getSnombre() {
        return this.snombre;
    }
    
    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }
    public String getPapellido() {
        return this.papellido;
    }
    
    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }
    public String getSapellido() {
        return this.sapellido;
    }
    
    public void setSapellido(String sapellido) {
        this.sapellido = sapellido;
    }
    public Set<Correos> getCorreoses() {
        return this.correoses;
    }
    
    public void setCorreoses(Set<Correos> correoses) {
        this.correoses = correoses;
    }
    public Set<Telefonos> getTelefonoses() {
        return this.telefonoses;
    }
    
    public void setTelefonoses(Set<Telefonos> telefonoses) {
        this.telefonoses = telefonoses;
    }
    public Set<Usuarios> getUsuarioses() {
        return this.usuarioses;
    }
    
    public void setUsuarioses(Set<Usuarios> usuarioses) {
        this.usuarioses = usuarioses;
    }




}


