package br.com.forum.controller.dto;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;

import br.com.forum.modelo.AbstractBaseEntity;
import br.com.forum.modelo.Topic;

public class TopicoDto extends GenericDto{
	
    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String emailAutor;

    public TopicoDto() {}
    
    public TopicoDto(Topic topico) {
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getCreateDate();
        this.emailAutor = topico.getUser().getEmail();
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

    public static Page<TopicoDto> converter(Page<Topic> topicos) {
        return topicos.map(TopicoDto::new);
    }
    
    public TopicoDto parseFromEntity(AbstractBaseEntity entity) {
        return new TopicoDto((Topic) entity);
    }

    public static TopicoDto newDtoParseFromEntity(AbstractBaseEntity entity) {
    	return new TopicoDto((Topic) entity);
    }
	public String getEmailAutor() {
		return emailAutor;
	}
	public void setEmailAutor(String emailAutor) {
		this.emailAutor = emailAutor;
	}
}

