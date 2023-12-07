package consume.control.Entity.ConsumoEnergetico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Table(name = "consumoEnergetico")
@Entity(name = "consumoEnergetico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConsumoEnergetico {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double watts;
    private double billValue;
    private String billMonth;

    public ConsumoEnergetico(ConsumoEnergeticoRecordDTO dados) {
        watts = dados.watts();
        billValue = dados.billValue();
        billMonth = dados.billMonth();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWatts() {
        return watts;
    }

    public void setWatts(double watts) {
        this.watts = watts;
    }

    public double getBillValue() {
        return billValue;
    }

    public void setBillValue(double billValue) {
        this.billValue = billValue;
    }

    public String getBillMonth() {
        return billMonth;
    }

    public void setBillMonth(String billMonth) {
        this.billMonth = billMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsumoEnergetico that = (ConsumoEnergetico) o;
        return Double.compare(watts, that.watts) == 0 && Double.compare(billValue, that.billValue) == 0 && Objects.equals(id, that.id) && Objects.equals(billMonth, that.billMonth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, watts, billValue, billMonth);
    }
}
