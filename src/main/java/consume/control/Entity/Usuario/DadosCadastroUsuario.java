package consume.control.Entity.Usuario;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroUsuario(
        @NotBlank
        String nome,
        @NotBlank
        String email) {
}
