package com.SigaBem.demo.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class FreteResponse {
    @Schema(description = "Response de Valor total do frete: Type BigDecimal")
    private BigDecimal vlTotalFrete;
    @Schema(description = "Response da Data prevista para entrega: Type Integer")
    private Integer dataPrevistaEntrega;
    @Schema(description = "Response Do Cep de origem: Type String")
    private String cepOrigem;
    @Schema(description = "Response Do Cep de destino: Type String")
    private String cepDestino;
}
