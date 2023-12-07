package consume.control.Controller;


import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivo;
import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivoRecordDTO;
import consume.control.Repository.ConsumoDispositivosRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ConsumeDispositivosController {
    @Autowired
    private ConsumoDispositivosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<ConsumoUsoDispositivo> register(@RequestBody @Valid ConsumoUsoDispositivoRecordDTO dados){
        return ResponseEntity.ok(repository.save(new ConsumoUsoDispositivo(dados)));
    }

    @GetMapping
    public ResponseEntity<List<ConsumoUsoDispositivo>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

        /*
        update by month

        @PutMapping("/{billMonth}")
        @Transactional
        public ResponseEntity<ConsumoUsoDispositivo> updateByMonth(@PathVariable String month){
            ConsumoEnergetico consume = repository.findByMonth();
            return ResponseEntity.ok();
        }

        // get by month?
    */

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ConsumoUsoDispositivo> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

