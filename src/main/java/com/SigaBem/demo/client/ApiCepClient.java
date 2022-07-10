package com.SigaBem.demo.client;

import com.SigaBem.demo.client.model.ApiCepResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ApiCepClient {
    @GetMapping("/{cep}/json")
    ApiCepResponse consultaCep(@PathVariable("cep") String cep);
}
