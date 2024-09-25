package com.example.CaixaSugestaoAnonima.dtos;

import java.time.LocalDateTime;

public class RespostaRequest {

    private Long sugestaoId;

    private String texto;

    private LocalDateTime dataEnvio = LocalDateTime.now();

    public RespostaRequest() {
    }

    public RespostaRequest(Long sugestaoId, String texto, LocalDateTime dataEnvio) {
        this.sugestaoId = sugestaoId;
        this.texto = texto;
        this.dataEnvio = dataEnvio;
    }

    public Long getSugestaoId() {
        return sugestaoId;
    }

    public void setSugestaoId(Long sugestaoId) {
        this.sugestaoId = sugestaoId;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }
}
