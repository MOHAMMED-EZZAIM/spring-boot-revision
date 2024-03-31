package usa.harvard.tp1_commande.ws.dto;

import java.util.List;

    public class CommandeDto {
    private String ref;
    private double montantTotal;
    private double montantPayeCheque;
    private double montantPayeEspece;

        public String getRef() {
            return ref;
        }

        public void setRef(String ref) {
            this.ref = ref;
        }

        public double getMontantTotal() {
            return montantTotal;
        }

        public void setMontantTotal(double montantTotal) {
            this.montantTotal = montantTotal;
        }

        public double getMontantPayeCheque() {
            return montantPayeCheque;
        }

        public void setMontantPayeCheque(double montantPayeCheque) {
            this.montantPayeCheque = montantPayeCheque;
        }

        public double getMontantPayeEspece() {
            return montantPayeEspece;
        }

        public void setMontantPayeEspece(double montantPayeEspece) {
            this.montantPayeEspece = montantPayeEspece;
        }

        public List<PaiementDto> getPaiements() {
            return paiements;
        }

        public void setPaiements(List<PaiementDto> paiements) {
            this.paiements = paiements;
        }

        private List<PaiementDto> paiements;
}
