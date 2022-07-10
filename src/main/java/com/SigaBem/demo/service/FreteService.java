package com.SigaBem.demo.service;

import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import com.SigaBem.demo.model.entity.FreteEntity;

import java.math.BigDecimal;
import java.util.List;

public interface FreteService {
    /**
     * Retorna o FreteResponse com o calculo
     * @param req
     * @return freteResponse
     */
    FreteResponse calcFrete(FreteRequest req);

    /**
     * Retorna todos os fretes armazenados
     *
     * @return lista de fretes
     */
    List<FreteResponse> getFretesList();

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
