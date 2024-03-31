package usa.harvard.tp1_commande.service.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.dao.TypePaiementDao;
import usa.harvard.tp1_commande.ws.dto.TypePaiementDto;

import java.util.List;

    public interface TypePaiementService {
     TypePaiementDto findByCode(String code);

     int save(TypePaiementDto typePaiement);

     int deleteByCode(String code);

     List<TypePaiementDto> findAll();

     int update(TypePaiementDto typePaiementNew);
    }

