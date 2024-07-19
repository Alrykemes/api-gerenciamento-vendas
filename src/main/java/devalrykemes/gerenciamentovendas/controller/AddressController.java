package devalrykemes.gerenciamentovendas.controller;

import devalrykemes.gerenciamentovendas.domain.address.AddressRequestDto;
import devalrykemes.gerenciamentovendas.domain.address.AddressResponseDto;
import devalrykemes.gerenciamentovendas.domain.address.Address;
import devalrykemes.gerenciamentovendas.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class AddressController {
    @Autowired
    AddressRepository repository;

    @GetMapping
    public ResponseEntity listAllAddress() {
        List<AddressResponseDto> listAddress = repository.findAll().stream().map(AddressResponseDto::new).toList();
        return ResponseEntity.ok(listAddress);
    }

    @PostMapping
    public ResponseEntity saveAddress(@RequestBody AddressRequestDto addressData) {
        Address address = new Address(addressData);
        repository.save(address);
        return ResponseEntity.ok().build();
    }

}
