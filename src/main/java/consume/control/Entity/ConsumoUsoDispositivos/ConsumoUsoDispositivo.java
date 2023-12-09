package consume.control.Entity.ConsumoUsoDispositivos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import consume.control.Entity.Usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Optional;

@Table(name = "consumoAparelho")
@Entity(name = "consumoAparelho")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoUsoDispositivo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_consumoa;
    private LocalTime deviceConsume;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public ConsumoUsoDispositivo(ConsumoUsoDispositivoRecordDTO dados) {
        deviceConsume = dados.deviceConsume();
    }

    public LocalTime getDeviceConsume() {
        return deviceConsume;
    }

    public void setDeviceConsume(LocalTime deviceConsume) {
        this.deviceConsume = deviceConsume;
    }

    public void setUsuario(Usuario usuario) {

        this.usuario = usuario;
        if (!usuario.getConsumoDispositivos().contains(this)) {
            usuario.getConsumoDispositivos().add(this);
        }
    }
}
