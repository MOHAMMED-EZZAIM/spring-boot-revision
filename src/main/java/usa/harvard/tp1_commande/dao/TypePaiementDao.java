package usa.harvard.tp1_commande.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usa.harvard.tp1_commande.bean.TypePaiement;

import java.util.List;


@Repository
public interface TypePaiementDao extends JpaRepository<TypePaiement,Long> {
    TypePaiement findByCode(String code);
    int deleteByCode(String code);
    }
