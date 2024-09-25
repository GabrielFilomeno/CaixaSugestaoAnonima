package com.example.CaixaSugestaoAnonima.services;

import com.example.CaixaSugestaoAnonima.dtos.SugestaoDto;
import com.example.CaixaSugestaoAnonima.dtos.SugestaoFiltro;
import com.example.CaixaSugestaoAnonima.dtos.SugestaoResponse;
import com.example.CaixaSugestaoAnonima.dtos.SugestaoRespostaResponse;
import com.example.CaixaSugestaoAnonima.entities.RespostaEntity;
import com.example.CaixaSugestaoAnonima.entities.SugestaoEntity;
import com.example.CaixaSugestaoAnonima.mappers.SugestaoMapper;
import com.example.CaixaSugestaoAnonima.repositories.RespostaRepository;
import com.example.CaixaSugestaoAnonima.repositories.SugestaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SugestaoService {

    private static final Logger log = LoggerFactory.getLogger(SugestaoService.class);
    private final SugestaoRepository sugestaoRepository;
    private final RespostaRepository respostaRepository;
    private final SugestaoMapper sugestaoMapper;

    public SugestaoService(SugestaoRepository sugestaoRepository, RespostaRepository respostaRepository, SugestaoMapper sugestaoMapper) {
        this.sugestaoRepository = sugestaoRepository;
        this.respostaRepository = respostaRepository;
        this.sugestaoMapper = sugestaoMapper;
    }

    public SugestaoDto enviarSugestoes(SugestaoDto request) {

        log.info("Criando sugestão: {}", request.getTitulo());

        SugestaoEntity sugestaoEntity = new SugestaoEntity();

        BeanUtils.copyProperties(request, sugestaoEntity);

        sugestaoRepository.save(sugestaoEntity);

        log.info("Sugestão criada: {}", request.getTitulo());

        return request;
    }

    public Page<SugestaoResponse> listarSugestoes(SugestaoFiltro filtro, Pageable pageable) {

        log.info("Buscando sugestões");
        String filtroTitulo = filtro.getTituloSugestao() != null ? filtro.getTituloSugestao() : "";

        Page<SugestaoEntity> entityPage = sugestaoRepository.findByTituloContainingIgnoreCaseOrderByDataAtualizacaoDesc(filtroTitulo, pageable);

        Page<SugestaoResponse> response = sugestaoMapper.toResponse(entityPage);

        log.info("Sugestões encontradas: {}", response.getTotalElements());

        return response;
    }

    public SugestaoRespostaResponse sugestaoPorId(Long id) {

        log.info("Buscando sugestão com ID: {}", id );

        SugestaoEntity sugestaoEntity = sugestaoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Sugestão não encontrada com o ID: " + id)
        );

        List<RespostaEntity> respostaEntityList = respostaRepository.findAllBySugestaoIdOrderByDataEnvioDesc(id);
        SugestaoRespostaResponse sugestaoRespostaResponse = new SugestaoRespostaResponse();

        BeanUtils.copyProperties(sugestaoEntity, sugestaoRespostaResponse);
        sugestaoRespostaResponse.setRespostas(respostaEntityList);

        log.info("Sugestão encontrada com ID: {}", id );

        return sugestaoRespostaResponse;
    }
}
