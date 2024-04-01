package usa.harvard.tp1_commande.service.facade;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.ws.dto.CommandeDto;
import java.util.List;
public interface CommandeService {

    List<Paiement> getPaiementsByCommandeId(String ref);

    List<CommandeDto> findAll();
    int deleteByRef(String ref);

    int  save(CommandeDto commandeDto);

    CommandeDto findByRef(String ref);

    List<CommandeDto> findNonPaye();

    List<CommandeDto> findPaye();

    int update(CommandeDto commandeDto);


}
