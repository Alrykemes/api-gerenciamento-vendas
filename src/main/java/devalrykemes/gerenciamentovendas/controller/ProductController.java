package devalrykemes.gerenciamentovendas.controller;

import devalrykemes.gerenciamentovendas.domain.product.ProductRequestDto;
import devalrykemes.gerenciamentovendas.domain.product.ProductResponseDto;
import devalrykemes.gerenciamentovendas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ProductRequestDto> saveProduct(@RequestBody ProductRequestDto productData) {
        this.productService.createProduct(productData);
        return ResponseEntity.ok(productData);
    }

    @PutMapping("/{productID}")
    public ResponseEntity<ProductResponseDto> updateProduct(@PathVariable("productID") Integer productID, @RequestBody ProductRequestDto productData) {
        return ResponseEntity.ok(this.productService.updateProduct(productID, productData));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        return ResponseEntity.ok(this.productService.findAll());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Integer productId) {
        return ResponseEntity.ok(this.productService.getProductDetails(productId));
    }

    @DeleteMapping("/{productID}")
    public ResponseEntity deleteProduct(@PathVariable Integer productID) {
        this.productService.deleteProduct(productID);
        return ResponseEntity.ok("Produto com ID: " + productID  + " deletado com sucesso!");
    }
}
