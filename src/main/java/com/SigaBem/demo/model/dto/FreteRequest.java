package com.SigaBem.demo.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty(value = "peso", required = true)
    @Positive(message = "O peso deve ser positivo")
    private Double peso;

    @JsonProperty(value = "cepOrigem", required = true)
    @NotNull(message = "Cep não pode ser vazio")
    private String cepOrigem;

    @JsonProperty(value = "cepDestino", required = true)
    @NotNull(message = "Cep não pode ser vazio")
    private String cepDestino;

    @JsonProperty(value = "nomeDestinatario", required = true)
    @NotNull(message = "Nome não pode ser vazio")
    private String nomeDestinatario;
}
