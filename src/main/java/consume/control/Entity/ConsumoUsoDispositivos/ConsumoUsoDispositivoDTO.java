package consume.control.Entity.ConsumoUsoDispositivos;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ConsumoUsoDispositivoDTO(
        @NotNull
        Date consumedHours
) {
}
