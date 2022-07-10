package com.SigaBem.demo.service;

import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import org.springframework.stereotype.Service;

public interface FreteService {
    FreteResponse calcFrete(FreteRequest req);
}
