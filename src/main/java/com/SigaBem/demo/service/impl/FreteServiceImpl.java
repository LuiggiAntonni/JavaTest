package com.SigaBem.demo.service.impl;

import com.SigaBem.demo.client.ApiCepClient;
import com.SigaBem.demo.client.model.ApiCepResponse;
import com.SigaBem.demo.exception.BusinessException;
import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import com.SigaBem.demo.model.entity.FreteEntity;
import com.SigaBem.demo.model.mapper.FreteMapper;
import com.SigaBem.demo.repository.FreteRepository;
import com.SigaBem.demo.service.FreteService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FreteServiceImpl implements FreteService {
    @Autowired
    private ApiCepClient client;

    @Autowired
    private FreteRepository repository;

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

            repository.save(FreteMapper.toFreteEntity(req, freteResponse));

            return freteResponse;
        }
        catch (Exception exception) {
            log.error("Erro ao calcular frete: ", exception.getMessage());
            throw new BusinessException("Erro interno");
        }
    }
    @SneakyThrows
    @Override
    public List<FreteResponse> getFretesList() {
        try {
            return FreteMapper.ToFreteListResponse(repository.findAll());
        }
        catch (Exception exception){
            throw new BusinessException("Erro interno");
        }
    }

    /**
     * <p>- CEPs com DDDs iguais tem 50% de desconto no valor do frete e entrega prevista de 1 dia</p>
     * <p>- CEPs de estados iguais tem 75% de desconto no valor do frete e entrega prevista de 3 dias</p>
     * <p>- CEPs de estados diferentes não deve ser aplicado o desconto no valor do frete e entrega prevista de 10 dias</p>
     * <p>- O valor do frete é cobrado pelo peso da encomenda, o valor para cada KG é R$1,00</p>
     * @param freteResponse
     * @param peso
     * @param apiReqCepOrigem
     * @param apiReqCepDestino
     */
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
