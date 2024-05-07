package com.softex.avaliacao.domain.service;

import com.softex.avaliacao.domain.model.Customer;
import com.softex.avaliacao.domain.validators.CustomerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerValidator customerValidator;

    public Customer findByCpf(String cpf){
        customerValidator.validaConsultaPorCpf(cpf);

        Customer customer = Customer
                .builder()
                .id(UUID.randomUUID())
                .cpf(cpf)
                .nome("Jose")
                .build();

        return customer;
    }

}
