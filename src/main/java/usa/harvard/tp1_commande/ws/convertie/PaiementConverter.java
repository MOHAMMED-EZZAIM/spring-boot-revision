package usa.harvard.tp1_commande.ws.convertie;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.ws.dto.PaiementDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaiementConverter {
    private Long id;

    private String code;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime datePaiement;

    private double montant;

    @JsonProperty("encaissement")
    private boolean encaissement;

    @ManyToOne
    private TypePaiement typePaiement;

    @ManyToOne
    private Commande commande;

    public PaiementDto toDto(Paiement paiement){
        PaiementDto paiementDto=new PaiementDto();
        paiementDto.setCode(paiement.getCode());
        paiementDto.setDatePaiement(paiement.getDatePaiement());
        paiementDto.setMontant(paiement.getMontant());
        paiementDto.setEncaissement(paiement.isEncaissement());
        paiementDto.setTypePaiementDto(typePaiementConverter.toDto(paiement.getTypePaiement()));
        paiementDto.setCommandeDto(commandeConverter.toDto(paiement.getCommande()));
        return  paiementDto;
    }
    public Paiement toBean(PaiementDto paiementDto){
        Paiement paiement=new Paiement();
        paiement.setCode(paiementDto.getCode());
        paiement.setDatePaiement(paiementDto.getDatePaiement());
        paiement.setMontant(paiementDto.getMontant());
        paiement.setEncaissement(paiementDto.isEncaissement());
        paiement.setTypePaiement(typePaiementConverter.toBean(paiementDto.getTypePaiementDto()));
        paiement.setCommande(commandeConverter.toBean(paiementDto.getCommandeDto()));
        return paiement;
    }
    public List<Paiement> toBean(List<PaiementDto> dtos){
        List<Paiement> result = new ArrayList<>();
        for(PaiementDto dto : dtos){
            result.add(toBean(dto));
        }
        return  result ;
    }
    public List<PaiementDto> toDto(List<Paiement> beans){
        return beans.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Autowired
    private PaiementConverter paiementConverter;
    @Autowired
    private TypePaiementConverter typePaiementConverter;
    @Autowired
    private CommandeConverter commandeConverter;
}
