package usa.harvard.tp1_commande.service.facade;
import org.springframework.transaction.annotation.Transactional;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.ws.dto.PaiementDto;

import java.util.List;
public interface PaimentService {
    List<PaiementDto> findAll();

    @Transactional
    int encasser(String code);

    @Transactional
    int save(String refCommande, PaiementDto paiement);

    int update(PaiementDto paiementDto);

    PaiementDto findByCode(String code);

    int deleteByCode(String code);

    List<Paiement> findPaiementByCommandeRef(String refCommande);
}

