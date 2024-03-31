package usa.harvard.tp1_commande.ws.dto;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import java.time.LocalDateTime;

public class PaiementDto {
    private String code;
    private LocalDateTime datePaiement ;
    private double montant;
    private  boolean encaissement ;
    private TypePaiementDto typePaiementDto;
    private CommandeDto commandeDto ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDateTime datePaiement) {
        this.datePaiement = datePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isEncaissement() {
        return encaissement;
    }

    public void setEncaissement(boolean encaissement) {
        this.encaissement = encaissement;
    }

    public TypePaiementDto getTypePaiementDto() {
        return typePaiementDto;
    }

    public void setTypePaiementDto(TypePaiementDto typePaiementDto) {
        this.typePaiementDto = typePaiementDto;
    }

    public CommandeDto getCommandeDto() {
        return commandeDto;
    }

    public void setCommandeDto(CommandeDto commandeDto) {
        this.commandeDto = commandeDto;
    }
}
