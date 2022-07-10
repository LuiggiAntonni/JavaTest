package com.SigaBem.demo.controller;

import com.SigaBem.demo.exception.BusinessException;
import com.SigaBem.demo.model.dto.FreteRequest;
import com.SigaBem.demo.model.dto.FreteResponse;
import com.SigaBem.demo.model.entity.FreteEntity;
import com.SigaBem.demo.service.FreteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Tag(name = "Frete")
@RequestMapping(value = "/api/fretes")
@RestController
public class FreteController {
    @Autowired
    private FreteService service;

    @Operation(summary = "Rota de cálculo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(schema = @Schema(implementation = FreteResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = BusinessException.class))),
            @ApiResponse(responseCode = "500", description = "Internal server erro", content = @Content(schema = @Schema(implementation = BusinessException.class)))
    })
    @PostMapping(value = "/calcular")
    public FreteResponse calcFrete(@RequestBody @Valid FreteRequest req) {
        return service.calcFrete(req);
    }

    @GetMapping
    public List<FreteResponse> getFretes() { return service.getFretesList(); }
}
