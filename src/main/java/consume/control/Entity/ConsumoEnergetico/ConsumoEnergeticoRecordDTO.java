package consume.control.Entity.ConsumoEnergetico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ConsumoEnergeticoRecordDTO(
        @NotNull
        double watts,
        @NotNull
        double billValue,
        @NotBlank
        String billMonth
) {
}
