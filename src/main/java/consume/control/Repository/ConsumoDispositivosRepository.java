package consume.control.Repository;

import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsumoDispositivosRepository extends JpaRepository<ConsumoUsoDispositivo, Long> {
}
