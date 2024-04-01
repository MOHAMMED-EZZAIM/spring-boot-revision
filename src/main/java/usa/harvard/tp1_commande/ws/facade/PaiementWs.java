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



    @GetMapping("/listPaimentByCommandeRef/{refCommande}")
    public List<Paiement> findPaiementByCommandeRef(@PathVariable String refCommande) {
        return service.findPaiementByCommandeRef(refCommande);
    }

    @Autowired
    private PaimentService service;

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return service.deleteByCode(code);
    }

    @GetMapping("/code/{code}")
    public PaiementDto findByCode(@PathVariable String code) { // Ajout de @PathVariable
        return service.findByCode(code);
    }


    @PutMapping("/encaisser/{code}")
    public int encasser(@PathVariable String code) {
        return service.encasser(code);
    }
    @PutMapping
    public int update(PaiementDto paiementDto) {
        return service.update(paiementDto);
    }


    @PostMapping("/refCommande/{refCommande}")
    public int save(@PathVariable String refCommande, @RequestBody PaiementDto paiement) {
        return service.save(refCommande, paiement);
    }

    @GetMapping
    public List<PaiementDto> findAll() {
        return service.findAll();
    }
}