package consume.control.Controller;

import consume.control.Entity.Usuario.DadosCadastroUsuario;
import consume.control.Entity.Usuario.Usuario;
import consume.control.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar (@RequestBody @Valid DadosCadastroUsuario dados) {
        repository.save(new Usuario(dados));
    }
}
