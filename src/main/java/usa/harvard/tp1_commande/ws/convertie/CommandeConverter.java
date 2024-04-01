package usa.harvard.tp1_commande.ws.convertie;

import jakarta.persistence.OneToMany;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.dao.CommandeDao;
import usa.harvard.tp1_commande.dao.PaiementDao;
import usa.harvard.tp1_commande.service.facade.CommandeService;
import usa.harvard.tp1_commande.service.impl.TypePaiementServiceImpl;
import usa.harvard.tp1_commande.ws.dto.CommandeDto;

import java.util.ArrayList;
import java.util.List;

import static usa.harvard.tp1_commande.enume.TypePaimentEnum.CHEQUE;
import static usa.harvard.tp1_commande.enume.TypePaimentEnum.ESPECE;

@Component
public class CommandeConverter {
    private String ref;
    private double montantTotal;
    private double montantPayeCheque;
    private double montantPayeEspece;

    @OneToMany
    private List<Paiement> paiementList;

    public Commande toBean(CommandeDto dto) {
        Commande bean = new Commande();
        bean.setPaiementList(paiementConverter.toBean(dto.getPaiements()));
        bean.setMontantPayeEspece(dto.getMontantPayeEspece());
        bean.setMontantPayeCheque(dto.getMontantPayeCheque());
        bean.setMontantTotal(dto.getMontantTotal());
        bean.setRef(dto.getRef());
        return bean;
    }

    public CommandeDto toDto(Commande bean) {
        CommandeDto dto = new CommandeDto();
        dto.setPaiements(paiementConverter.toDto(bean.getPaiementList()));
        dto.setMontantPayeEspece(bean.getMontantPayeEspece());
        dto.setMontantPayeCheque(bean.getMontantPayeCheque());
        dto.setMontantTotal(bean.getMontantTotal());
        dto.setRef(bean.getRef());

        return dto;
    }

    public List<Commande> toBean(List<CommandeDto> dtos) {
        List<Commande> beans = new ArrayList<>();
        for (CommandeDto dto : dtos) {
            beans.add(toBean(dto));
        }
        return beans;
    }

    public List<CommandeDto> toDto(List<Commande> beans) {
        List<CommandeDto> dtos = new ArrayList<>();
        for (Commande dto : beans) {
            dtos.add(toDto(dto));
        }
        return dtos;
    }

    @Autowired
   private PaiementConverter paiementConverter;
}
