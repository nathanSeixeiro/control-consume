package consume.control.Controller;

import consume.control.Entity.ConsumoEnergetico.ConsumoEnergetico;
import consume.control.Entity.ConsumoEnergetico.ConsumoEnergeticoRecordDTO;
import consume.control.Repository.ConsumoEnergeticoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumo/energy")
public class ConsumoEnergeticoController {
    @Autowired
    private ConsumoEnergeticoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsumoEnergetico> register(@RequestBody @Valid ConsumoEnergeticoRecordDTO dados){
        return ResponseEntity.ok(repository.save(new ConsumoEnergetico(dados)));
    }

    @GetMapping
    public ResponseEntity<List<ConsumoEnergetico>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    /*
    update by month

    @PutMapping("/{billMonth}")
    @Transactional
    public ResponseEntity<ConsumoEnergetico> updateByMonth(@PathVariable String month){
        ConsumoEnergetico consume = repository.findByMonth();
        return ResponseEntity.ok();
    }

    // get by month?
*/

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ConsumoEnergetico> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
