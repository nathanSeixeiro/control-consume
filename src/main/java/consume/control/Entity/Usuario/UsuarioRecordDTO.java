package consume.control.Entity.Usuario;

import jakarta.validation.constraints.NotBlank;

public record UsuarioRecordDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email) {

}
