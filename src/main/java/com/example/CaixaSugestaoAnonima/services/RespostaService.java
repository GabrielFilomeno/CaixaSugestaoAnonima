package com.example.CaixaSugestaoAnonima.services;

import com.example.CaixaSugestaoAnonima.dtos.RespostaRequest;
import com.example.CaixaSugestaoAnonima.dtos.RespostaResponse;
import com.example.CaixaSugestaoAnonima.entities.RespostaEntity;
import com.example.CaixaSugestaoAnonima.entities.SugestaoEntity;
import com.example.CaixaSugestaoAnonima.repositories.RespostaRepository;
import com.example.CaixaSugestaoAnonima.repositories.SugestaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespostaService {

    private static final Logger log = LoggerFactory.getLogger(SugestaoService.class);
    private final RespostaRepository respostaRepository;
    private final SugestaoRepository sugestaoRepository;

    public RespostaService(RespostaRepository respostaRepository, SugestaoRepository sugestaoRepository) {
        this.respostaRepository = respostaRepository;
        this.sugestaoRepository = sugestaoRepository;
    }

    public RespostaRequest enviarResposta(RespostaRequest request) {
        log.info("Criando resposta para sugestão com ID: {}", request.getSugestaoId());

        SugestaoEntity sugestaoEntity = sugestaoRepository.findById(request.getSugestaoId()).orElseThrow(
                () -> new RuntimeException("Sugestão não encontrada com o ID:" + request.getSugestaoId())
        );

        sugestaoEntity.setDataAtualizacao(LocalDateTime.now());

        RespostaEntity respostaEntity = new RespostaEntity();

        BeanUtils.copyProperties(request, respostaEntity);

        sugestaoRepository.save(sugestaoEntity);
        respostaRepository.save(respostaEntity);
        log.info("Resposta criada para sugestão com ID: {}", request.getSugestaoId());

        return request;
    }
}
