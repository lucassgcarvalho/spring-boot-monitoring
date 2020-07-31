/*
 * Decompiled with CFR 0.145.
 *
 * Could not load the following classes:
 *  br.com.forum.controller.form.AtualizacaoTopicoForm
 *  br.com.forum.modelo.Topico
 *  br.com.forum.repository.TopicoRepository
 *  javax.validation.constraints.NotEmpty
 *  javax.validation.constraints.NotNull
 *  org.hibernate.validator.constraints.Length
 */
package br.com.forum.controller.form;

import br.com.forum.modelo.Topic;
import br.com.forum.repository.TopicoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AtualizacaoTopicoForm {
    @NotNull
    @NotEmpty
    @Length(min = 5)
    private String titulo;

    @NotNull
    @NotEmpty
    @Length(min = 10)
    private String mensagem;

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topic atualizar(Long id, TopicoRepository topicoRepository) {
        Topic topico = topicoRepository.getOne(id);
        topico.setTitulo(this.titulo);
        topico.setMensagem(this.mensagem);
        return topico;
    }
}

