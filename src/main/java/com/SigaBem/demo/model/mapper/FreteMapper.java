package com.SigaBem.demo.model.mapper;

import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import com.SigaBem.demo.model.entity.FreteEntity;

public class FreteMapper {

    public static FreteEntity toFreteEntity(FreteRequest request, FreteResponse response) {
        return FreteEntity.builder()
                .peso(request.getPeso())
                .cepOrigem(request.getCepOrigem())
                .cepDestino(request.getCepDestino())
                .nomeDestinatario(request.getNomeDestinatario())
                .vlTotalFrete(response.getVlTotalFrete())
                .dataPrevistaEntrega(response.getDataPrevistaEntrega())
                .build();
    }
}
