package com.SigaBem.demo.controller;

import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import com.SigaBem.demo.service.FreteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Frete")
@RequestMapping(value = "/api")
@RestController
public class FreteController {
    @Autowired
    private FreteService service;
    
    @PostMapping(value = "/frete")
    FreteResponse calcFrete(@RequestBody @Valid FreteRequest req) {
        return service.calcFrete(req);
    }
}
