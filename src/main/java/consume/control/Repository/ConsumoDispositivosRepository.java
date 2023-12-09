package consume.control.Repository;

import consume.control.Entity.ConsumoEnergetico.ConsumoEnergetico;
import consume.control.Entity.ConsumoEnergetico.ConsumoEnergeticoRecordDTO;
import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ConsumoDispositivosRepository extends JpaRepository<ConsumoUsoDispositivo, Long> {
}
