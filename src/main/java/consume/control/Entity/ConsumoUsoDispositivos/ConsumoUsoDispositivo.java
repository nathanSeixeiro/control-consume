package consume.control.Entity.ConsumoUsoDispositivos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalTime;
import java.util.Date;

@Table(name = "deviceConsumption")
@Entity(name = "deviceConsumption")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoUsoDispositivo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalTime consumedHours;

    public ConsumoUsoDispositivo(ConsumoUsoDispositivoRecordDTO dados) {
        consumedHours = dados.consumedHours();
    }

    public LocalTime getConsumedHours() {
        return consumedHours;
    }

    public void setConsumedHours(LocalTime consumedHours) {
        this.consumedHours = consumedHours;
    }
}
