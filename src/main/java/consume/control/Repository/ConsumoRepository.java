package consume.control.Repository;

import consume.control.Entity.Consumo.Consumo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
}
