package usa.harvard.tp1_commande.ws.dto;

import lombok.Data;


public class TypePaiementDto {
    private String code ;
    private  String libelle;

    public String getCode() {

        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
