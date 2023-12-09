package consume.control.Repository;

import consume.control.Entity.ConsumoEnergetico.ConsumoEnergetico;
import consume.control.Entity.ConsumoEnergetico.ConsumoEnergetico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumoEnergeticoRepository extends JpaRepository<ConsumoEnergetico, Long> {
    List<ConsumoEnergetico> findByBillMonth(String billMonth);
}
