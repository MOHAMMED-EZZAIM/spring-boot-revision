package usa.harvard.tp1_commande.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import usa.harvard.tp1_commande.bean.Paiement;

import java.util.List;

@Repository
public interface PaiementDao extends JpaRepository<Paiement,Long> {
    int deleteByCode(String code);
    Paiement findByCode(String code);

    @Query(value = "SELECT p FROM Paiement p JOIN p.commande c WHERE c.ref = :refCommande")
    List<Paiement> findPaiementByCommandeRef(@Param("refCommande") String refCommande);

}
