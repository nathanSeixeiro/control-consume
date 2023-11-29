package consume.control.Entity.ConsumoUsoDispositivos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "deviceConsumption")
@Entity(name = "deviceConsumption")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoUsoDispositivo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date consumedHours;

    public ConsumoUsoDispositivo(ConsumoUsoDispositivoDTO dados) {
        consumedHours = dados.consumedHours();
    }
}
