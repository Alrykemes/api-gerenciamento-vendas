package devalrykemes.gerenciamentovendas.domain.sale;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public record SaleRequestDto(List<Integer> productsIds) {
}
