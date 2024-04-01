package usa.harvard.tp1_commande.ws.facade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.harvard.tp1_commande.service.facade.CommandeService;
import usa.harvard.tp1_commande.ws.dto.CommandeDto;

import java.util.List;

@RestController
@RequestMapping("api/commande/")
public class CommandeWs {


    @GetMapping
    public List<CommandeDto> findAll() {
        return commandeService.findAll();
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return commandeService.deleteByRef(ref);
    }

    @PostMapping
    public int save(@RequestBody CommandeDto commandeDto) {
        return commandeService.save(commandeDto);
    }

    @GetMapping("/code/{ref}")
    public CommandeDto findByRef(@PathVariable String ref) {
        return commandeService.findByRef(ref);
    }

    @GetMapping("/notePayes")
    public List<CommandeDto> findNonPaye() {
        return commandeService.findNonPaye();
    }
    @GetMapping("/Payes")
    public List<CommandeDto> findPaye() {
        return commandeService.findPaye();
    }

    @PutMapping
    public int update(@RequestBody CommandeDto commandeDto) {
      return  commandeService.update(commandeDto);
    }

    @Autowired
    private CommandeService commandeService;
}
