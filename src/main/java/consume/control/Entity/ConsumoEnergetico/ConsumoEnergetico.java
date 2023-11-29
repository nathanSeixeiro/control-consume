package consume.control.Entity.ConsumoEnergetico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consumoEnergetico")
@Entity(name = "consumoEnergetico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoEnergetico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double watts;
    private double billValue; // pq n existe flor preta???
    private String billMonth;

    public ConsumoEnergetico(DadosConsumoEnergetico dados) {
        watts = dados.watts();
        billValue = dados.billValue();
        billMonth = dados.billMonth();
    }
}
