package devalrykemes.gerenciamentovendas.service;

import devalrykemes.gerenciamentovendas.domain.product.Product;
import devalrykemes.gerenciamentovendas.domain.client.Client;
import devalrykemes.gerenciamentovendas.domain.product.ProductResponseDto;
import devalrykemes.gerenciamentovendas.domain.sale.Sale;
import devalrykemes.gerenciamentovendas.domain.sale.SaleRequestDto;
import devalrykemes.gerenciamentovendas.domain.sale.SaleResponseDto;
import devalrykemes.gerenciamentovendas.repository.ClientRepository;
import devalrykemes.gerenciamentovendas.repository.ProductRepository;
import devalrykemes.gerenciamentovendas.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ClientRepository clientRepository;

    public Sale createSale(Integer clientID, SaleRequestDto data) {
        Client client = clientRepository.findById(clientID)
                .orElseThrow(() -> new IllegalArgumentException("Client not found!"));

        Sale newSale = new Sale();
        newSale.setClient(client);
        Iterable<Integer> products = data.productsIds();
        newSale.setProducts(productRepository.findAllById(products));
        BigDecimal total = newSale.getProducts()
                .stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        newSale.setPrice(total);
        newSale.setDate(new Date());

        return this.saleRepository.save(newSale);
    }

    public List<SaleResponseDto> findAll() {
       return this.saleRepository.findAll().stream().map(sale -> new SaleResponseDto(
               sale.getId(),
               sale.getClient(),
               sale.getProducts().stream().map(product -> new ProductResponseDto(
                       product.getId(),
                       product.getName(),
                       product.getDescription(),
                       product.getPrice())
               ).toList(),
               sale.getDate(),
               sale.getPrice()
               )).toList();
    }

    public SaleResponseDto getSalesDetails(Integer id) {
        Sale sale = this.saleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Sale not found!"));

        return new SaleResponseDto(
                sale.getId(),
                sale.getClient(),
                sale.getProducts().stream().map(product -> new ProductResponseDto(
                        product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice())
                ).toList(),
                sale.getDate(),
                sale.getPrice()
        );
    }

    public void deleteSale(Integer id) {
        this.saleRepository.deleteById(id);
    }
}