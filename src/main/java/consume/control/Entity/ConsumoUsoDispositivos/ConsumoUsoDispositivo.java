package consume.control.Entity.ConsumoUsoDispositivos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Table(name = "consumoAparelho")
@Entity(name = "consumoAparelho")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoUsoDispositivo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime deviceConsume;

    public ConsumoUsoDispositivo(ConsumoUsoDispositivoRecordDTO dados) {
        deviceConsume = dados.deviceConsume();
    }

    public LocalTime getDeviceConsume() {
        return deviceConsume;
    }

    public void setDeviceConsume(LocalTime deviceConsume) {
        this.deviceConsume = deviceConsume;
    }
}
