package devalrykemes.gerenciamentovendas.controller;

import devalrykemes.gerenciamentovendas.domain.sale.Sale;
import devalrykemes.gerenciamentovendas.domain.sale.SaleRequestDto;
import devalrykemes.gerenciamentovendas.domain.sale.SaleResponseDto;
import devalrykemes.gerenciamentovendas.service.SaleService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @PostMapping("/cliente/{clientId}")
    public ResponseEntity saveSale(@PathVariable Integer clientId, @RequestBody SaleRequestDto saleData) {
        this.saleService.createSale(clientId, saleData);
        return ResponseEntity.ok("Nova Venda Feita para o Cliente com o ID: " +
                clientId + "\n Detalhes: " + saleData);
    }

    @GetMapping
    public ResponseEntity<List<SaleResponseDto>> getAllSales() {
        return ResponseEntity.ok(this.saleService.findAll());
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SaleResponseDto> getSaleById(@PathVariable Integer saleId) {
        return ResponseEntity.ok(this.saleService.getSalesDetails(saleId));
    }

    @DeleteMapping("/{saleId}")
    public ResponseEntity deleteSaleById(@PathVariable Integer saleId) {
        this.saleService.deleteSale(saleId);
        return ResponseEntity.ok("Venda com o ID: " + saleId + " Deletada com Sucesso!");
    }


}
