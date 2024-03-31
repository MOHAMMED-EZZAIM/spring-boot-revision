package usa.harvard.tp1_commande.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.harvard.tp1_commande.bean.Paiement;
import usa.harvard.tp1_commande.service.facade.PaimentService;
import usa.harvard.tp1_commande.ws.dto.PaiementDto;

import java.util.List;

@RestController
@RequestMapping("api/paiement/")
public class PaiementWs {
    @Autowired
    private PaimentService service;

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }

    @GetMapping("/code/{code}")
    public Paiement findByCode(@PathVariable String code) { // Ajout de @PathVariable
        return service.findByCode(code);
    }


    @PutMapping("/encaisser/{code}")
    public int encasser(@PathVariable String code) { // Correction de la faute de frappe dans le nom du chemin
        return service.encasser(code); // Correction de la faute de frappe dans le nom de la méthode
    }

    @PostMapping("/refCommande/{refCommande}")
    public int save(@PathVariable String refCommande, @RequestBody Paiement paiement) { // Ajout de @PathVariable
        return service.save(refCommande, paiement);
    }

    @GetMapping
    public List<Paiement> findAll() {
        return service.findAll();
    }
}