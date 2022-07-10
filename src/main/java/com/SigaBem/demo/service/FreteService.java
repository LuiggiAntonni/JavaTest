package com.SigaBem.demo.service;

import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface FreteService {
    /**
     * Retorna o FreteResponse com o calculo
     * @param req
     * @return freteResponse
     */
    FreteResponse calcFrete(FreteRequest req);

    /**
     * Calculadora de desconto
     * @param desconto
     * @param peso
     * @param valorPorKg
     * @return valor do frete com ou sem desconto
     */
    default BigDecimal calculoDeDesconto(Double desconto, Double peso, BigDecimal valorPorKg) {
        var desc = new BigDecimal(desconto).multiply(new BigDecimal(peso));
        var totalFreteSemDesc = new BigDecimal(peso).multiply(valorPorKg);
        return totalFreteSemDesc.subtract(desc);

    }
}
