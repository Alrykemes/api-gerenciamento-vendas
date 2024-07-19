package devalrykemes.gerenciamentovendas.domain.sale;

import devalrykemes.gerenciamentovendas.domain.client.Client;
import devalrykemes.gerenciamentovendas.domain.product.Product;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public record SaleResponseDto(Integer id, Client client,
                              List<Product> products, Date date,
                              BigDecimal price) {
    public SaleResponseDto(Sale sale) {
        this(sale.getId(), sale.getClient(), sale.getProducts(), sale.getDate(), sale.getPrice());
    }
}
