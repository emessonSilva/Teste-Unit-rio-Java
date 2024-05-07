package com.softex.avaliacao.domain.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    public void validaConsultaPorCpf(String cpf){
        validaSeCPFEstaPreenchido(cpf);
        validaTamanhoCpf(cpf);
        validaFormatoCpf(cpf);
    }

    private void validaSeCPFEstaPreenchido(String cpf){
        if(cpf == null || cpf.isEmpty()) {
            throw new RuntimeException("Cpf não pode ser vazio!!");
        }
    }

    private void validaTamanhoCpf(String cpf) {
        if (cpf.length() != 11) {
            throw new RuntimeException("O cpf deve possuir 11 caracters");
        }
    }

    private void validaFormatoCpf(String cpf){
        if (!StringUtils.isNumeric(cpf)) {
            throw new RuntimeException("O cpf deve ser numerico");
        }
    }
}
