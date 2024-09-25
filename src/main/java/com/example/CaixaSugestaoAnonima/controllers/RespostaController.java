package com.example.CaixaSugestaoAnonima.controllers;

import com.example.CaixaSugestaoAnonima.dtos.RespostaRequest;
import com.example.CaixaSugestaoAnonima.dtos.RespostaResponse;
import com.example.CaixaSugestaoAnonima.services.RespostaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    private static final Logger log = LoggerFactory.getLogger(RespostaController.class);
    private final RespostaService respostaService;


    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @PostMapping
    public RespostaRequest enviarResposta(@RequestBody RespostaRequest request) {

        log.info("POST /resposta -> Inicio");

        RespostaRequest response = respostaService.enviarResposta(request);

        log.info("POST /resposta -> Fim");

        return response;
    }
}
