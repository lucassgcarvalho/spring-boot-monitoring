/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.dto.RespostaDto
 *  br.com.forum.modelo.Resposta
 *  br.com.forum.modelo.Usuario
 */
package br.com.forum.controller.dto;

import br.com.forum.modelo.Answer;
import br.com.forum.modelo.User;
import java.time.LocalDateTime;
import java.util.Objects;

public class RespostaDto {
    private Long id;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;

    public RespostaDto(Answer resposta) {
        Objects.requireNonNull(resposta);
        this.id = resposta.getId();
        this.mensagem = resposta.getMessage();
        this.dataCriacao = resposta.getCreateDate();
        this.nomeAutor = resposta.getAuthor().getName();
    }

    public Long getId() {
        return this.id;
    }

    public String getMensagem() {
        return this.mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public String getNomeAutor() {
        return this.nomeAutor;
    }
}

