package usa.harvard.tp1_commande.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TypePaiement {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String code ;
    private  String libelle;
}
