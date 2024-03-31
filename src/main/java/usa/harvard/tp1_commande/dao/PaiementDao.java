package usa.harvard.tp1_commande.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usa.harvard.tp1_commande.bean.Paiement;

@Repository
public interface PaiementDao extends JpaRepository<Paiement,Long> {
    int deleteByCode(String code);
    Paiement findByCode(String code);

}
