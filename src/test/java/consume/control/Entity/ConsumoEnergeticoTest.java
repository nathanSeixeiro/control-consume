package consume.control.Entity;

import consume.control.Entity.ConsumoEnergetico.ConsumoEnergetico;
import consume.control.Entity.ConsumoEnergetico.ConsumoEnergeticoRecordDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class ConsumoEnergeticoTest {
    @Test
    public void itShouldCreateEnergyConsume(){

    ConsumoEnergeticoRecordDTO dadosDTO = new ConsumoEnergeticoRecordDTO(12.2, 10.10, "maio");
    ConsumoEnergetico consumoEnergetico = new ConsumoEnergetico(dadosDTO);

    assertNotNull(dadosDTO);
    assertNotNull(consumoEnergetico);
    assertEquals(dadosDTO.watts(),dadosDTO.billValue(), dadosDTO.billMonth());
    assertEquals(consumoEnergetico.getWatts(), consumoEnergetico.getBillValue(), consumoEnergetico.getBillMonth());
    }

    // metodos

}
