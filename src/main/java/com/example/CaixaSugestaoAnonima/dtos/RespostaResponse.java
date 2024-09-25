package com.example.CaixaSugestaoAnonima.dtos;

import java.time.LocalDateTime;

public class RespostaResponse {

    private Long id;

    private Long sugestaoId;

    private String texto;

    private LocalDateTime dataEnvio;

    public RespostaResponse() {
    }

    public RespostaResponse(Long id, LocalDateTime dataEnvio, String texto, Long sugestaoId) {
        this.id = id;
        this.dataEnvio = dataEnvio;
        this.texto = texto;
        this.sugestaoId = sugestaoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Long getSugestaoId() {
        return sugestaoId;
    }

    public void setSugestaoId(Long sugestaoId) {
        this.sugestaoId = sugestaoId;
    }
}
