package devalrykemes.gerenciamentovendas.domain.sale;

import devalrykemes.gerenciamentovendas.domain.client.Client;
import devalrykemes.gerenciamentovendas.domain.product.Product;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public record SaleRequestDto(Client client, List<Product> products, BigDecimal price, Date date) {
}
