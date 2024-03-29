package consume.control.Controller;

import consume.control.Entity.ConsumoEnergetico.ConsumoEnergetico;
import consume.control.Entity.Usuario.UsuarioCompletoDTO;
import consume.control.Entity.Usuario.UsuarioRecordDTO;
import consume.control.Entity.Usuario.Usuario;
import consume.control.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Usuario> register (@RequestBody @Valid UsuarioRecordDTO dados) {
        return ResponseEntity.ok(repository.save(new Usuario(dados)));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getUser() {
        List<Usuario> usuarios = repository.findAll();

        List<UsuarioCompletoDTO> usuariosDTO = usuarios.stream().map(usuario -> new UsuarioCompletoDTO(usuario, usuario.getConsumoDispositivos(), usuario.getConsumosEnergeticos())).collect(Collectors.toList());

        return ResponseEntity.ok(usuarios);
    }
    /*
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

     */

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
