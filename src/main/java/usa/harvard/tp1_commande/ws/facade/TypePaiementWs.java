package usa.harvard.tp1_commande.ws.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import usa.harvard.tp1_commande.service.facade.TypePaiementService;
import usa.harvard.tp1_commande.ws.dto.TypePaiementDto;

import java.util.List;

@RestController
@RequestMapping("/api/typePaiement/")
public class TypePaiementWs {

    @GetMapping("/code/{code}")
    public TypePaiementDto findByCode(@PathVariable  String code) {
        return typePaiementService.findByCode(code);
    }

    @PostMapping
    public int save(@RequestBody TypePaiementDto typePaiement) {
        return typePaiementService.save(typePaiement);
    }

    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typePaiementService.deleteByCode(code);
    }

    @GetMapping
    public List<TypePaiementDto> findAll() {
        return typePaiementService.findAll();
    }

    @PutMapping
    public int update(@RequestBody TypePaiementDto typePaiementDto) {
        return typePaiementService.update(typePaiementDto);
    }

    @Autowired
    private TypePaiementService typePaiementService;
}
