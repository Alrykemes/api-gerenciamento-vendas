package devalrykemes.gerenciamentovendas.domain.product;

import java.math.BigDecimal;

public record ProductResponseDto(Integer id, String name, String description, BigDecimal price) {
    public ProductResponseDto(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
