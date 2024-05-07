package com.softex.avaliacao.application.controllers;

import com.softex.avaliacao.domain.model.Customer;
import com.softex.avaliacao.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") UUID id){
        Customer customer = Customer
                                    .builder()
                                    .id(id)
                                    .cpf("123")
                                    .nome("Jose")
                                    .build();

        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{cpf}/cpf")
    public ResponseEntity<Customer> findByCpf(@PathVariable("cpf") String cpf){
        Customer customer = customerService.findByCpf(cpf);

        return ResponseEntity.ok(customer);
    }
}
