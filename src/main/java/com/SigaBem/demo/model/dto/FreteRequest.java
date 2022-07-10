package com.SigaBem.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreteRequest {
    @Schema(description = "Request para peso: Type Double")
    @JsonProperty(value = "peso", required = true)

    @Positive(message = "O peso deve ser positivo")
    private Double peso;

    @Schema(description = "Request para o Cep de Origem: Type String")
    @JsonProperty(value = "cepOrigem", required = true)
    @NotNull(message = "Cep não pode ser vazio")
    private String cepOrigem;

    @Schema(description = "Request para o Cep de destino: Type String")
    @JsonProperty(value = "cepDestino", required = true)
    @NotNull(message = "Cep não pode ser vazio")
    private String cepDestino;

    @Schema(description = "Request para o Nome do destinatario: Type String")
    @JsonProperty(value = "nomeDestinatario", required = true)
    @NotNull(message = "Nome não pode ser vazio")
    private String nomeDestinatario;
}
