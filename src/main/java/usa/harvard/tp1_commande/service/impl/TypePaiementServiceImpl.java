package usa.harvard.tp1_commande.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import usa.harvard.tp1_commande.bean.TypePaiement;
import usa.harvard.tp1_commande.dao.TypePaiementDao;
import usa.harvard.tp1_commande.service.facade.TypePaiementService;
import usa.harvard.tp1_commande.ws.convertie.TypePaiementConverter;
import usa.harvard.tp1_commande.ws.dto.TypePaiementDto;

import java.util.List;

@Service
    public class TypePaiementServiceImpl implements TypePaiementService {

    @Override
    public TypePaiementDto findByCode(String code) {

        return converter.toDto(typePaiementDao.findByCode(code));
    }

    @Override
    public int save(TypePaiementDto typePaiement) {
        if(typePaiementDao.findByCode(typePaiement.getCode())!=null){
           return -1;
       }
       else {
            System.out.println(typePaiement.getCode());
            System.out.println(typePaiement.getLibelle());
            typePaiementDao.save(converter.toBean(typePaiement));
            return 1;
       }
    }

    @Transactional
    @Override
    public int deleteByCode(String code) {
      return typePaiementDao.deleteByCode(code);
    }

    @Override
    public List<TypePaiementDto> findAll() {
       return converter.toDto(typePaiementDao.findAll());
    }

    @Override
    public int update(TypePaiementDto typePaiementNew) {
        if ( typePaiementNew == null) {
            return -1;
        } else {
            TypePaiement typePaiement = typePaiementDao.findByCode(typePaiementNew.getCode());
            if (typePaiement != null) {
                typePaiement.setCode(typePaiementNew.getCode());
                typePaiement.setLibelle(typePaiementNew.getLibelle());
                typePaiementDao.save(typePaiement);
                return 1;
            } else {
                return -2;
            }
        }
    }

    @Autowired
    private TypePaiementDao typePaiementDao;
    @Autowired
    private TypePaiementConverter converter;
}

