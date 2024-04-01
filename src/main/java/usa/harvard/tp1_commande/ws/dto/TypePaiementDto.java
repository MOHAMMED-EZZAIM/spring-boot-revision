package usa.harvard.tp1_commande.ws.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TypePaiementDto {

    private String code ;

    private  String libelle;

}
