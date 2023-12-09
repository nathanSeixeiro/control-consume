package consume.control.Controller;

import consume.control.Entity.ConsumoEnergetico.ConsumoEnergetico;
import consume.control.Entity.ConsumoEnergetico.ConsumoEnergeticoRecordDTO;
import consume.control.Entity.Usuario.Usuario;
import consume.control.Repository.ConsumoEnergeticoRepository;
import consume.control.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consume/energy")
public class ConsumoEnergeticoController {
    @Autowired
    UsuarioRepository userRepo;
    @Autowired
    private ConsumoEnergeticoRepository repository;

    @PostMapping("/{id_user}")
    @Transactional
    public ResponseEntity<ConsumoEnergetico> register(@PathVariable Long id_user,@RequestBody @Valid ConsumoEnergeticoRecordDTO dados){
        try {
            Optional<Usuario> usuarioOptional = userRepo.findById(id_user);
            Usuario usuario = usuarioOptional.get();
            ConsumoEnergetico consumoE = new ConsumoEnergetico(dados);
            consumoE.setUsuario(usuario);
            return ResponseEntity.ok(repository.save(consumoE));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<ConsumoEnergetico>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/search/{billMonth}")
    public ResponseEntity<List<ConsumoEnergetico>> getByBillMonhth(@PathVariable String billMonth) {
        List<ConsumoEnergetico> consumos = repository.findByBillMonth(billMonth);
        return ResponseEntity.ok(consumos);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<ConsumoEnergetico> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
