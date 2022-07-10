package com.SigaBem.demo.service.impl;

import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import com.SigaBem.demo.service.FreteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FreteServiceImpl implements FreteService {
    @Override
    public FreteResponse calcFrete(FreteRequest req) {
        FreteResponse FreteResponse = com.SigaBem.demo.model.dto.FreteResponse.builder()
                .build();
        return FreteResponse;
    }
}
