package com.example.CaixaSugestaoAnonima.dtos;

import com.example.CaixaSugestaoAnonima.entities.RespostaEntity;

import java.time.LocalDateTime;
import java.util.List;

public class SugestaoRespostaResponse {

    private Long id;

    private String titulo;

    private String descricao;

    private LocalDateTime dataEnvio;

    private LocalDateTime dataAtualizacao;

    private List<RespostaEntity> respostas;

    public SugestaoRespostaResponse() {
    }

    public SugestaoRespostaResponse(List<RespostaEntity> respostas, LocalDateTime dataAtualizacao, LocalDateTime dataEnvio, String descricao, String titulo, Long id) {
        this.respostas = respostas;
        this.dataAtualizacao = dataAtualizacao;
        this.dataEnvio = dataEnvio;
        this.descricao = descricao;
        this.titulo = titulo;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public List<RespostaEntity> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<RespostaEntity> respostas) {
        this.respostas = respostas;
    }
}
