package com.SigaBem.demo.service;

import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

public interface FreteService {
    FreteResponse calcFrete(FreteRequest req);

    default BigDecimal calculoDeDesconto(Double desconto, Double peso, BigDecimal valorPorKg) {
        var desc = new BigDecimal(desconto).multiply(new BigDecimal(peso));
        var totalFreteSemDesc= new BigDecimal(peso).multiply(valorPorKg);
        return totalFreteSemDesc.subtract(desc);

    }
}
