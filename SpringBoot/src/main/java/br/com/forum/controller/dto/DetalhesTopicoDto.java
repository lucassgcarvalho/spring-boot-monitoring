/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.dto.DetalhesTopicoDto
 *  br.com.forum.controller.dto.RespostaDto
 *  br.com.forum.modelo.StatusTopico
 *  br.com.forum.modelo.Topico
 *  br.com.forum.modelo.Usuario
 */
package br.com.forum.controller.dto;

import br.com.forum.controller.dto.RespostaDto;
import br.com.forum.modelo.StatusTopic;
import br.com.forum.modelo.Topic;
import br.com.forum.modelo.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DetalhesTopicoDto {
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopic status;
    private List<RespostaDto> respostas;

    public DetalhesTopicoDto(Topic topico) {
        Objects.requireNonNull(topico);
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getCreateDate();
        this.nomeAutor = topico.getUser().getName();
        this.status = topico.getStatus();
        this.respostas = topico.getListAnswer().stream().map(RespostaDto::new).collect(Collectors.toList());
    }

    public Long getId() {
        return this.id;
    }

    public String getTitulo() {
        return this.titulo;
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

    public StatusTopic getStatus() {
        return this.status;
    }

    public List<RespostaDto> getRespostas() {
        return this.respostas;
    }
}

