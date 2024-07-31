package devalrykemes.gerenciamentovendas.service;

import devalrykemes.gerenciamentovendas.domain.product.Product;
import devalrykemes.gerenciamentovendas.domain.product.ProductRequestDto;
import devalrykemes.gerenciamentovendas.domain.product.ProductResponseDto;
import devalrykemes.gerenciamentovendas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public Product createProduct(ProductRequestDto productData) {
        Product newProduct = new Product();
        newProduct.setName(productData.name());
        newProduct.setDescription(productData.description());
        newProduct.setPrice(productData.price());

        productRepository.save(newProduct);

        return newProduct;
    }

    public ProductResponseDto updateProduct(Integer id, ProductRequestDto productData) {
        Optional<Product> product = productRepository.findById(id);

        product.get().setName(productData.name());
        product.get().setDescription(productData.description());
        product.get().setPrice(productData.price());
        productRepository.save(product.get());

        return new ProductResponseDto(
                product.get().getId(),
                product.get().getName(),
                product.get().getDescription(),
                product.get().getPrice());
    }

    public List<ProductResponseDto> findAll() {
        return productRepository.findAll().stream().map(product -> new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice())
                ).toList();
    }

    public ProductResponseDto getProductDetails(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Product not found"));

        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public void deleteProduct(Integer id) {
        this.productRepository.deleteById(id);
    }


}
