package consume.control.Entity;

import consume.control.Entity.Usuario.Usuario;
import consume.control.Entity.Usuario.UsuarioRecordDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioTest {
    @Test
    public void itShouldCreateUsuario(){
        UsuarioRecordDTO userDto = new UsuarioRecordDTO("nome","email@email.com");
        Usuario user = new Usuario(userDto);

        assertNotNull(userDto);
        assertNotNull(user);
        assertEquals(userDto.nome(), user.getNome());
    }
}
