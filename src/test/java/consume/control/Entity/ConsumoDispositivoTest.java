package consume.control.Entity;

import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivo;
import consume.control.Entity.ConsumoUsoDispositivos.ConsumoUsoDispositivoRecordDTO;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsumoDispositivoTest {
    @Test
    public void itShouldCreateDeviceConsume(){
        ConsumoUsoDispositivoRecordDTO dadosDTO = new ConsumoUsoDispositivoRecordDTO(LocalTime.of(15, 30));
        ConsumoUsoDispositivo consumoUsoDispositivo = new ConsumoUsoDispositivo((dadosDTO));

        assertNotNull(dadosDTO);
        assertNotNull(consumoUsoDispositivo);
        assertNotNull(dadosDTO.consumedHours());
        assertNotNull(consumoUsoDispositivo.getConsumedHours());
    }
}
