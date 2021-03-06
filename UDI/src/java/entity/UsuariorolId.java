package entity;
// Generated 07-jul-2015 11:43:32 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * UsuariorolId generated by hbm2java
 */
public class UsuariorolId  implements java.io.Serializable {


     private BigDecimal codrol;
     private BigDecimal idusu;

    public UsuariorolId() {
    }

    public UsuariorolId(BigDecimal codrol, BigDecimal idusu) {
       this.codrol = codrol;
       this.idusu = idusu;
    }
   
    public BigDecimal getCodrol() {
        return this.codrol;
    }
    
    public void setCodrol(BigDecimal codrol) {
        this.codrol = codrol;
    }
    public BigDecimal getIdusu() {
        return this.idusu;
    }
    
    public void setIdusu(BigDecimal idusu) {
        this.idusu = idusu;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsuariorolId) ) return false;
		 UsuariorolId castOther = ( UsuariorolId ) other; 
         
		 return ( (this.getCodrol()==castOther.getCodrol()) || ( this.getCodrol()!=null && castOther.getCodrol()!=null && this.getCodrol().equals(castOther.getCodrol()) ) )
 && ( (this.getIdusu()==castOther.getIdusu()) || ( this.getIdusu()!=null && castOther.getIdusu()!=null && this.getIdusu().equals(castOther.getIdusu()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCodrol() == null ? 0 : this.getCodrol().hashCode() );
         result = 37 * result + ( getIdusu() == null ? 0 : this.getIdusu().hashCode() );
         return result;
   }   


}


