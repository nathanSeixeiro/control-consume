package consume.control.Entity.ConsumoEnergetico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ConsumoEnergeticoRecordDTO(
        @NotBlank
        double watts,
        @NotBlank
        double billValue,
        @NotNull
        String billMonth
) {
}
