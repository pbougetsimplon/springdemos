package fr.bouget.jpa.model;

import java.io.Serializable;

/**
 * 
 * @author Philippe
 * Classe de clef composée de l'entity Vin
 *
 */

public class VinPK implements Serializable {
    public static final long serialVersionUID=56439876525L;
    
    private Integer codeProduit;
    private String designation;
	
    public VinPK(){
        setCodeProduit(0);
        setDesignation(null);
    } 
	
    public VinPK(Integer codeProduit, String designation)
    {
        this.codeProduit=codeProduit;
        this.designation=designation;
    }

    public Integer getCodeProduit() {
        return codeProduit;
    }

    public void setCodeProduit(Integer codeProduit) {
        this.codeProduit = codeProduit;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj instanceof VinPK){
        VinPK pk=(VinPK)obj;
            return codeProduit.equals(pk.codeProduit) && designation.equals(pk.designation);
        }else{
            return false;
        }
    }

    @Override
    public int hashCode(){	
        return  super.hashCode()+27*codeProduit.hashCode()+51*designation.hashCode();
    }

    @Override
    public String toString(){
        return "codeProduit="+codeProduit+" designation="+designation;
    }
}
