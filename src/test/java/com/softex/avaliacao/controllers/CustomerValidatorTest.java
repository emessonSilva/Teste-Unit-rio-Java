package com.softex.avaliacao.controllers;

import com.softex.avaliacao.domain.validators.CustomerValidator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;



@ExtendWith(MockitoExtension.class)
class CustomerValidatorTest {

    @Mock
    private CustomerValidator customerValidator;

    @Test
    void testCpfValido() {
        String cpf = "12345678901";
        assertDoesNotThrow(() -> customerValidator.validaConsultaPorCpf(cpf));
    }

    @Test
    void testCpfVazio() {
        String cpf = "";
        Mockito.doThrow(new RuntimeException("Cpf não pode ser vazio!!"))
                .when(customerValidator).validaConsultaPorCpf(cpf);
        assertThrows(RuntimeException.class, () -> customerValidator.validaConsultaPorCpf(cpf));
    }

    @Test
    void testCpfTamanhoInvalido() {
        String cpf = "12345";
        Mockito.doThrow(new RuntimeException("O cpf deve possuir 11 caracteres"))
                .when(customerValidator).validaConsultaPorCpf(cpf);
        assertThrows(RuntimeException.class, () -> customerValidator.validaConsultaPorCpf(cpf));
    }

    @Test
    void testCpfNaoNumerico() {
        String cpf = "12345abcde";
        Mockito.doThrow(new RuntimeException("O cpf deve ser numerico"))
                .when(customerValidator).validaConsultaPorCpf(cpf);
        assertThrows(RuntimeException.class, () -> customerValidator.validaConsultaPorCpf(cpf));
    }

}