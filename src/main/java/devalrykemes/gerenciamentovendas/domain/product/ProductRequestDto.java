package devalrykemes.gerenciamentovendas.domain.product;

import java.math.BigDecimal;

public record ProductRequestDto(String name, String description, BigDecimal price) {
}
