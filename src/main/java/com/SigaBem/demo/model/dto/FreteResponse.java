package com.SigaBem.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreteResponse {

    private BigDecimal vlTotalFrete;

    private Integer dataPrevistaEntrega;

    private String cepOrigem;

    private String cepDestino;
}
