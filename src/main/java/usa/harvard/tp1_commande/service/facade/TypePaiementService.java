package usa.harvard.tp1_commande.service.facade;

import usa.harvard.tp1_commande.ws.dto.TypePaiementDto;

import java.util.List;

    public interface TypePaiementService {
     TypePaiementDto findByCode(String code);

     int save(TypePaiementDto typePaiement);

     int deleteByCode(String code);

     List<TypePaiementDto> findAll();

     int update(TypePaiementDto typePaiementNew);


    }

