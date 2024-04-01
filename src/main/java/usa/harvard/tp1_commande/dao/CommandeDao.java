package usa.harvard.tp1_commande.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import usa.harvard.tp1_commande.bean.Commande;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.ws.dto.CommandeDto;

import java.util.List;

import static javax.swing.text.html.HTML.Tag.SELECT;

@Repository
public interface CommandeDao extends JpaRepository<Commande,Long> {
    int deleteByRef (String ref);
    Commande findByRef (String ref);
    List<Commande> findAll();

    @Query(value = "SELECT c FROM Commande c WHERE (c.montantPayeEspece + c.montantPayeCheque) < c.montantTotal")
    List<Commande> findNonPaye();

    @Query(value = "SELECT c FROM Commande c WHERE (c.montantPayeEspece + c.montantPayeCheque) = c.montantTotal")
    List<Commande> findPaye();




}

