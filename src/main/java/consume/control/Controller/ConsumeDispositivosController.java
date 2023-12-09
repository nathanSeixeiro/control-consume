package consume.control.Controller;


import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivo;
import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivoRecordDTO;
import consume.control.Entity.Usuario.Usuario;
import consume.control.Repository.ConsumoDispositivosRepository;
import consume.control.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("consume/device")
public class ConsumeDispositivosController {
    @Autowired
    UsuarioRepository userRepo;
    @Autowired
    private ConsumoDispositivosRepository repository;

    @PostMapping("/{id_user}")
    @Transactional
    public ResponseEntity<ConsumoUsoDispositivo> register(@PathVariable Long id_user,@RequestBody @Valid ConsumoUsoDispositivoRecordDTO dados){
        try {
            Optional<Usuario> usuarioOptional = userRepo.findById(id_user);
            Usuario usuario = usuarioOptional.get();
            ConsumoUsoDispositivo consumoD = new ConsumoUsoDispositivo(dados);
            consumoD.setUsuario(usuario);
            return ResponseEntity.ok(repository.save(consumoD));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ConsumoUsoDispositivo>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ConsumoUsoDispositivo> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/total")
    public ResponseEntity getTotalTime(){
        var consume = repository.findAll();
        long totalSeconds = consume.stream()
            .mapToLong(consumo -> consumo.getDeviceConsume().toSecondOfDay())
            .sum();

        LocalTime totalTime = LocalTime.ofSecondOfDay(totalSeconds);
        return ResponseEntity.ok(totalTime);
    }

}

