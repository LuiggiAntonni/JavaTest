package com.SigaBem.demo.model.mapper;

import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import com.SigaBem.demo.model.entity.FreteEntity;

import java.util.ArrayList;
import java.util.List;

public class FreteMapper {
    /**
     * <p>Constroi um FreteEntity</p>
     * @param request
     * @param response
     * @return FreteEntity
     */
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

    /**
     * <p>Transforma uma lista de FreteEntity em FreteResponse</p>
     * @param freteEntityList
     * @return retorna uma List De FreteResponse
     */
    public static List<FreteResponse> ToFreteListResponse(List<FreteEntity> freteEntityList) {
        List<FreteResponse> list = new ArrayList<>();
        freteEntityList.forEach(freteEntity -> list.add(FreteResponse.builder()
                        .cepDestino(freteEntity.getCepDestino())
                        .cepOrigem(freteEntity.getCepOrigem())
                        .dataPrevistaEntrega(freteEntity.getDataPrevistaEntrega())
                        .vlTotalFrete(freteEntity.getVlTotalFrete())
                .build()));
        return list;
    }
}
