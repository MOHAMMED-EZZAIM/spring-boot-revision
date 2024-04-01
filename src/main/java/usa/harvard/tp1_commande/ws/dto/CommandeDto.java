package usa.harvard.tp1_commande.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
    public class CommandeDto {

    private String ref;
    private double montantTotal;
    private double montantPayeCheque;
    private double montantPayeEspece;
    private List<PaiementDto> paiements;
}
