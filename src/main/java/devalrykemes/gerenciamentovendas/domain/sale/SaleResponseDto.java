package devalrykemes.gerenciamentovendas.domain.sale;

import devalrykemes.gerenciamentovendas.domain.client.Client;
import devalrykemes.gerenciamentovendas.domain.product.Product;
import devalrykemes.gerenciamentovendas.domain.product.ProductResponseDto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record SaleResponseDto(Integer id,
                              Client client,
                              List<ProductResponseDto> products,
                              Date date,
                              BigDecimal price) {
    public SaleResponseDto(Sale sale) {
        this(sale.getId(), sale.getClient(), sale.getProducts().stream().map(product -> new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice())
        ).toList(), sale.getDate(), sale.getPrice());
    }
}
