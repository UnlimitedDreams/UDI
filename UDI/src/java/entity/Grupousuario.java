package entity;
// Generated 07-jul-2015 11:43:32 by Hibernate Tools 4.3.1



/**
 * Grupousuario generated by hbm2java
 */
public class Grupousuario  implements java.io.Serializable {


     private GrupousuarioId id;
     private Grupo grupo;
     private Usuarios usuarios;

    public Grupousuario() {
    }

    public Grupousuario(GrupousuarioId id, Grupo grupo, Usuarios usuarios) {
       this.id = id;
       this.grupo = grupo;
       this.usuarios = usuarios;
    }
   
    public GrupousuarioId getId() {
        return this.id;
    }
    
    public void setId(GrupousuarioId id) {
        this.id = id;
    }
    public Grupo getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public Usuarios getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }




}


