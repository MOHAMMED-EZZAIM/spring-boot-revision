package usa.harvard.tp1_commande.bean;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String code;

    private LocalDateTime datePaiement;

    private double montant;

    @JsonProperty("encaissement")
    private boolean encaissement;

    @ManyToOne(fetch = FetchType.LAZY)
    private TypePaiement typePaiement;

    @ManyToOne(fetch = FetchType.LAZY)
    private Commande commande;
}
