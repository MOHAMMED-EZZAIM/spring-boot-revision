package usa.harvard.tp1_commande.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.dao.CommandeDao;
import usa.harvard.tp1_commande.service.facade.CommandeService;
import usa.harvard.tp1_commande.ws.convertie.CommandeConverter;
import usa.harvard.tp1_commande.ws.dto.CommandeDto;

import java.util.Collections;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Override
    public List<Paiement> getPaiementsByCommandeId(String ref) {
        Commande commande = commandeDao.findByRef(ref);
        if (commande != null) {
            return commande.getPaiementList();
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public List<CommandeDto> findAll() {
        return converter.toDto(commandeDao.findAll());
    }

    @Transactional
    @Override
    public int deleteByRef(String ref) {
        return commandeDao.deleteByRef(ref);
    }


    @Override
    public int save(CommandeDto commandeDto) {
        Commande nouveauCommande = converter.toBean(commandeDto);
        Commande existingCommande = commandeDao.findByRef(commandeDto.getRef());
        if (commandeDto.getMontantPayeEspece() < 0 || commandeDto.getMontantPayeCheque() < 0 || commandeDto.getMontantTotal() < 0) {
            return -1;
        } else if (commandeDto.getMontantPayeEspece() +
                commandeDto.getMontantPayeCheque() > commandeDto.getMontantTotal()
        ) {
            return -2;
        } else if (commandeDto.getMontantTotal() == 0) {
            return -3;
        } else if (existingCommande != null) {
            update(commandeDto);
            return 2;
        } else {
//            List<Paiement> list=nouveauCommande.getPaiementList();
//            nouveauCommande.setPaiementList(list);
            commandeDao.save(nouveauCommande);
            return 1;

        }
    }

    @Override
    public CommandeDto findByRef(String ref) {
        return converter.toDto(commandeDao.findByRef(ref));
    }

    @Override
    public List<CommandeDto> findNonPaye() {
        return converter.toDto(commandeDao.findNonPaye());
    }

    @Override
    public List<CommandeDto> findPaye() {
        return converter.toDto(commandeDao.findPaye());
    }

    @Override
    public int update(CommandeDto commandeDto) {
        Commande existingCommande = commandeDao.findByRef(commandeDto.getRef());
        if (existingCommande != null) {
            BeanUtils.copyProperties(commandeDto, existingCommande);
            commandeDao.save(existingCommande);
            return 1;
        } else {
            return -1;
        }
    }



    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeConverter converter;
}
