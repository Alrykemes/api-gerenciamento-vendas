package devalrykemes.gerenciamentovendas.controller;

import devalrykemes.gerenciamentovendas.domain.product.ProductRequestDto;
import devalrykemes.gerenciamentovendas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ProductRequestDto> saveProduct(ProductRequestDto productData) {
        this.productService.createProduct(productData);
        return ResponseEntity.ok(productData);
    }
    
}
