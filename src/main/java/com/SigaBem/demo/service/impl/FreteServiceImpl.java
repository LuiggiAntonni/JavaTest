package com.SigaBem.demo.service.impl;

import com.SigaBem.demo.client.ApiCepClient;
import com.SigaBem.demo.client.model.ApiCepResponse;
import com.SigaBem.demo.exception.BusinessException;
import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import com.SigaBem.demo.service.FreteService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
public class FreteServiceImpl implements FreteService {
    @Autowired
    private ApiCepClient client;

    @SneakyThrows
    @Override
    public FreteResponse calcFrete(FreteRequest req) {
        try {
            var ApiReqCepOrigem = client.consultaCep(req.getCepOrigem());
            var ApiReqCepDestino = client.consultaCep(req.getCepDestino());

            FreteResponse freteResponse = FreteResponse.builder()
                    .cepOrigem(req.getCepOrigem())
                    .cepDestino(req.getCepDestino())
                    .build();

            descontoDoFrete(freteResponse, req.getPeso(), ApiReqCepOrigem, ApiReqCepDestino);

            return freteResponse;
        }
        catch (Exception exception) {
            log.error("Erro ao calcular frete: ", exception.getMessage());
            throw new BusinessException("Erro interno");
        }
    }

    private void descontoDoFrete(FreteResponse freteResponse, Double peso, ApiCepResponse apiReqCepOrigem, ApiCepResponse apiReqCepDestino) {
        var valorPorKg = new BigDecimal(1);
        var desconto = 0.0;
        var prevDiasEntrega = 10;

        if (apiReqCepOrigem.getDdd().equals(apiReqCepDestino.getDdd())){
            desconto = 0.5;
            prevDiasEntrega = 1;
        } else if (apiReqCepOrigem.getUf().equals(apiReqCepDestino.getUf())) {
            desconto = 0.75;
            prevDiasEntrega = 3;
        }

        freteResponse.setVlTotalFrete(calculoDeDesconto(desconto, peso, valorPorKg));
        freteResponse.setDataPrevistaEntrega(prevDiasEntrega);
    }
}
