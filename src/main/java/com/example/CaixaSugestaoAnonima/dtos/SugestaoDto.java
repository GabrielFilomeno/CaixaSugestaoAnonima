package com.example.CaixaSugestaoAnonima.dtos;

import java.time.LocalDateTime;

public class SugestaoDto {

    private String titulo;

    private String descricao;

    private LocalDateTime dataEnvio = LocalDateTime.now();

    private LocalDateTime dataAtualizacao = LocalDateTime.now();

    public SugestaoDto() {
    }

    public SugestaoDto(String titulo, String descricao, LocalDateTime dataEnvio, LocalDateTime dataAtualizacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataEnvio = dataEnvio;
        this.dataAtualizacao = dataAtualizacao;
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
}
