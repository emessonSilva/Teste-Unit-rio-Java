package com.softex.avaliacao.controllers;

import com.softex.avaliacao.domain.model.Customer;
import com.softex.avaliacao.domain.service.CustomerService;
import com.softex.avaliacao.domain.validators.CustomerValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerValidator customerValidator;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerService(customerValidator);
    }

    @Test
    void findByCpf_ValidCpf() {
        String cpf = "12345678901";
        Customer expectedCustomer = Customer.builder()
                .id(UUID.randomUUID())
                .cpf(cpf)
                .nome("Jose")
                .build();

        Mockito.doNothing().when(customerValidator).validaConsultaPorCpf(cpf);

        Customer actualCustomer = customerService.findByCpf(cpf);

        assertEquals(expectedCustomer.getCpf(), actualCustomer.getCpf());
        assertEquals(expectedCustomer.getNome(), actualCustomer.getNome());
    }


    @Test
    void findByCpf_InvalidCpf() {
        String cpf = "12345";

        Mockito.doThrow(new RuntimeException("CPF inválido"))
                .when(customerValidator).validaConsultaPorCpf(cpf);

        assertThrows(RuntimeException.class, () -> customerService.findByCpf(cpf));
    }


}