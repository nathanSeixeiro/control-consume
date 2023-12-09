package consume.control.Entity.Usuario;

import consume.control.Entity.ConsumoEnergetico.ConsumoEnergetico;
import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivo;

import java.util.List;

public record UsuarioCompletoDTO(Long id_usuario, String nome, String email, List<ConsumoUsoDispositivo> consumosD, List<ConsumoEnergetico> consumosE) {
    public UsuarioCompletoDTO(Usuario usuario, List<ConsumoUsoDispositivo> consumosD, List<ConsumoEnergetico> consumosE){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), consumosD, consumosE);
    }
}
