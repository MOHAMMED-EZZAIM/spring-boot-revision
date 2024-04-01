package usa.harvard.tp1_commande.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.dao.CommandeDao;
import usa.harvard.tp1_commande.dao.PaiementDao;
import usa.harvard.tp1_commande.dao.TypePaiementDao;
import usa.harvard.tp1_commande.service.facade.CommandeService;
import usa.harvard.tp1_commande.service.facade.PaimentService;
import usa.harvard.tp1_commande.service.facade.TypePaiementService;
import usa.harvard.tp1_commande.ws.convertie.CommandeConverter;
import usa.harvard.tp1_commande.ws.convertie.PaiementConverter;
import usa.harvard.tp1_commande.ws.convertie.TypePaiementConverter;
import usa.harvard.tp1_commande.ws.dto.CommandeDto;
import usa.harvard.tp1_commande.ws.dto.PaiementDto;

import java.util.List;

@Service
public class PaiementServiceImpl implements PaimentService {
    private static final String CHEQUE = "CHEQUE";
    private static final String ESPECE = "ESPECE";

    @Override
    public List<PaiementDto> findAll() {
        return paiementConverter.toDto(paiementDao.findAll());
    }

    @Override
    public int encasser(String code) {
        Paiement paiement = paiementDao.findByCode(code);
        if (paiement == null || paiement.getCommande() == null) {
            return -1;
        } else if (paiement.getTypePaiement().getCode() != null &&
                !paiement.getTypePaiement().getCode().equals(CHEQUE)) {
            return -2;
        } else if (paiement.isEncaissement()) {
            return -3;
        } else {
            paiement.setEncaissement(true);
            paiementDao.save(paiement);
            Commande commande = paiement.getCommande();
            commande.setMontantPayeCheque(commande.getMontantPayeCheque() - paiement.getMontant());
            commande.setMontantPayeEspece(commande.getMontantPayeEspece() - paiement.getMontant());
            commandeService.update(commandeConverter.toDto(commande));
            return 1;
        }
    }

//    @Override
//    public int save(String refCommande, PaiementDto paiement) {
//        if(paiement!=null){
//            CommandeDto commandeDto=commandeConverter.toDto(commandeDao.findByRef(refCommande));
//            TypePaiementDto typePaiementDto=typePaiementConverter.toDto(typePaiementDao.findByCode(paiement.getTypePaiementDto().getCode()));
//            if(commandeDto!=null&&typePaiementDto!=null){
//                commandeDto.setMontantPayeCheque(commandeDto.getMontantPayeCheque()-paiement.getMontant());
//                commandeDto.setMontantPayeEspece(commandeDto.getMontantPayeEspece()-paiement.getMontant());
//                commandeDao.save(commandeConverter.toBean(commandeDto));
//                typePaiementDao.save(typePaiementConverter.toBean(typePaiementDto));
//
//                System.out.println("=======================================");
//                System.out.println(paiement.getTypePaiementDto().getCode());
//                System.out.println(paiement.getCommandeDto().getRef());
//                System.out.println("=======================================");
//
//                paiement.setCommandeDto(commandeDto);
//                paiement.setTypePaiementDto(typePaiementDto);
//                paiementDao.save(paiementConverter.toBean(paiement));
//                return 1;
//            }
//            else {
//                return -1;
//            }
//        }
//        else {
//            return -2;
//        }
//    }


//    @Override
//    public int save(String refCommande, PaiementDto paiement) {
//        Commande commande=commandeDao.findByRef(refCommande);
//        String code =paiement.getTypePaiementDto().getCode();
//        TypePaiement typePaiement=typePaiementDao.findByCode(code);
//
//        if(commande==null){
//            return -1;
//        } else if (commande.getMontantPayeEspece()
//                +commande.getMontantPayeCheque()
//                +paiement.getMontant()>commande.getMontantTotal()){
//            return -2;
//
//        } else if ((typePaiement==null )||(typePaiement!=null && (!CHEQUE.equals(code) && !ESPECE.equals(code)))) {
//            return  -3;
//        }else {
//            paiementDao.save(paiementConverter.toBean(paiement));
//            if(ESPECE.equals(code)){
//                commande.setMontantPayeEspece(commande.getMontantPayeEspece()+paiement.getMontant());
//            }
//            if(CHEQUE.equals(code)){
//                commande.setMontantPayeCheque(commande.getMontantPayeCheque()+paiement.getMontant());
//            }
//            commandeService.update(commandeConverter.toDto(commande));
//            paiement.setCommandeDto(commandeConverter.toDto(commande));
//            paiement.setTypePaiementDto(typePaiementConverter.toDto(typePaiement));
//            paiementDao.save(paiementConverter.toBean(paiement));
//            return 1;
//        }
//    }

//    public int save(String refCommande, PaiementDto paiement) {
//        if (paiement != null && paiementDao.findByCode(paiement.getCode()) == null) {
//            Paiement paiement1 = paiementConverter.toBean(paiement);
//            Commande command = commandeDao.findByRef(refCommande);
//            TypePaiement typePaiement = typePaiementDao.findByCode(paiement.getTypePaiementDto().getCode());
//
//            if (command != null && typePaiement != null) {
//                command.setMontantPayeCheque(command.getMontantPayeCheque() - paiement.getMontant());
//                command.setMontantPayeEspece(command.getMontantPayeEspece() - paiement.getMontant());
//                commandeDao.save(command);
//                typePaiementDao.save(typePaiement);
//
//                paiement1.setCommande(command);
//                paiement1.setTypePaiement(typePaiement);
//                paiementDao.save(paiement1);
//                return 1;
//            } else {
//                return -2;
//            }
//        } else if (paiement != null && paiementDao.findByCode(paiement.getCode()) != null) {
//            update(paiement);
//            return 2;
//        } else {
//            return -1;
//        }
//    }



    public int save(String refCommande, PaiementDto paiement) {
        if (paiement == null || refCommande==null) {
            return -1;
        }

        Paiement existingPaiement = paiementDao.findByCode(paiement.getCode());
        if (existingPaiement != null) {
            update(paiement);
            return 2;
        }

        Paiement paiement1 = paiementConverter.toBean(paiement);

        Commande command = commandeDao.findByRef(refCommande);
        TypePaiement typePaiement = typePaiementDao.findByCode(paiement.getTypePaiementDto().getCode());

        if (command == null || typePaiement == null) {
            return -2;
        }

        command.setMontantPayeCheque(command.getMontantPayeCheque() - paiement.getMontant());
        command.setMontantPayeEspece(command.getMontantPayeEspece() - paiement.getMontant());
        commandeDao.save(command);
        typePaiementDao.save(typePaiement);

        paiement1.setCommande(command);
        paiement1.setTypePaiement(typePaiement);
        paiementDao.save(paiement1);

        return 1;
    }



    @Override
    public int update(PaiementDto paiementDto) {
        Paiement existingPaiment = paiementDao.findByCode(paiementDto.getCode());
        if (existingPaiment != null) {
            BeanUtils.copyProperties(paiementDto, existingPaiment);
            paiementDao.save(existingPaiment);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public PaiementDto findByCode(String code) {
        return paiementConverter.toDto(paiementDao.findByCode(code));
    }

    @Transactional
    @Override
    public int deleteByCode(String code) {
        return paiementDao.deleteByCode(code);
    }

    @Autowired
    private PaiementDao paiementDao;
    @Autowired
    private TypePaiementDao typePaiementDao;
    @Autowired
    private CommandeDao commandeDao;

    @Autowired
    private PaiementConverter paiementConverter;
    @Autowired
    private TypePaiementConverter typePaiementConverter;
    @Autowired
    private CommandeConverter commandeConverter;

    @Autowired
    private CommandeService commandeService;
    @Autowired
    private TypePaiementService typePaiementService;
}