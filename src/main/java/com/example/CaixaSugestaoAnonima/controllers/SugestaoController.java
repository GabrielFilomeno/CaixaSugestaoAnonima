package com.example.CaixaSugestaoAnonima.controllers;

import com.example.CaixaSugestaoAnonima.dtos.SugestaoDto;
import com.example.CaixaSugestaoAnonima.dtos.SugestaoFiltro;
import com.example.CaixaSugestaoAnonima.dtos.SugestaoResponse;
import com.example.CaixaSugestaoAnonima.dtos.SugestaoRespostaResponse;
import com.example.CaixaSugestaoAnonima.services.SugestaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sugestoes")
public class SugestaoController {

    private static final Logger log = LoggerFactory.getLogger(SugestaoController.class);
    private final SugestaoService sugestaoService;

    public SugestaoController(SugestaoService sugestaoService) {
        this.sugestaoService = sugestaoService;
    }

    @PostMapping
    public SugestaoDto enviarSugestoes(@RequestBody SugestaoDto request) {
        log.info("POST /sugestoes -> Inicio");

        SugestaoDto response = sugestaoService.enviarSugestoes(request);

        log.info("POST /sugestoes -> Fim");

        return response;
    }

    @GetMapping
    public Page<SugestaoResponse> listarSugestoes(@ParameterObject() SugestaoFiltro filtro,
                                                  @ParameterObject() @PageableDefault() Pageable pageable){
        log.info("GET /sugestoes -> Inicio");

        Page<SugestaoResponse> response = sugestaoService.listarSugestoes(filtro, pageable);

        log.info("GET /sugestoes -> Fim");

        return response;
    }

    @GetMapping("/{id}")
    public SugestaoRespostaResponse sugestaoPorId(@PathVariable Long id){

        log.info("GET /sugestoes/{id} -> Inicio");
        SugestaoRespostaResponse response = sugestaoService.sugestaoPorId(id);
        log.info("GET /sugestoes/{id} -> Fim");

        return response;
    }
}
