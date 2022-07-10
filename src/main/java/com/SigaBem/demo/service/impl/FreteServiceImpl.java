package com.SigaBem.demo.service.impl;

import com.SigaBem.demo.client.ApiCepClient;
import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import com.SigaBem.demo.service.FreteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FreteServiceImpl implements FreteService {
    @Autowired
    private ApiCepClient client;

    @Override
    public FreteResponse calcFrete(FreteRequest req) {
        var ApiReqCepOrigem = client.consultaCep(req.getCepOrigem());
        var ApiReqCepDestino = client.consultaCep(req.getCepDestino());

        FreteResponse freteResponse = FreteResponse.builder()
                .cepOrigem(req.getCepOrigem())
                .cepDestino(req.getCepDestino())
                .build();
        log.info(String.valueOf(ApiReqCepDestino.getDdd()));
        return freteResponse;
    }
}
