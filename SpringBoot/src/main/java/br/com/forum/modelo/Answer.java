/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.modelo.Resposta
 *  br.com.forum.modelo.Topico
 *  br.com.forum.modelo.Usuario
 *  javax.persistence.Entity
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.ManyToOne
 */
package br.com.forum.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String message;
    
    @ManyToOne
    private Topic topic;
    
    private LocalDateTime dreateDate = LocalDateTime.now();
    
    @ManyToOne
    private User author;
    
    private Boolean solution = false;

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Answer other = (Answer)obj;
        return !(this.id == null ? other.id != null : !this.id.equals(other.id));
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String mensagem) {
        this.message = mensagem;
    }

    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topico) {
        this.topic = topico;
    }

    public LocalDateTime getCreateDate() {
        return this.dreateDate;
    }

    public void setCreateDate(LocalDateTime dataCriacao) {
        this.dreateDate = dataCriacao;
    }

    public User getAuthor() {
        return this.author;
    }

    public void setAuthor(User autor) {
        this.author = autor;
    }

    public Boolean getSolution() {
        return this.solution;
    }

    public void setSolution(Boolean solucao) {
        this.solution = solucao;
    }
}

