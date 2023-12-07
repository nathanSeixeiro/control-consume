package consume.control.Entity.ConsumoUsoDispositivos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalTime;
import java.util.Date;

public record ConsumoUsoDispositivoRecordDTO(
        @NotNull
        LocalTime consumedHours
) {
}
