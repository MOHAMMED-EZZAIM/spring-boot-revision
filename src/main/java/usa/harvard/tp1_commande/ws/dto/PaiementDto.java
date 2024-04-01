package usa.harvard.tp1_commande.ws.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaiementDto {
    private String code;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime datePaiement ;
    private double montant;
    @JsonProperty("encaissement")
    private  boolean encaissement ;
    private TypePaiementDto typePaiementDto;
    private CommandeDto commandeDto ;

}
