package devalrykemes.gerenciamentovendas.service;

import devalrykemes.gerenciamentovendas.domain.product.Product;
import devalrykemes.gerenciamentovendas.domain.product.ProductRequestDto;
import devalrykemes.gerenciamentovendas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
