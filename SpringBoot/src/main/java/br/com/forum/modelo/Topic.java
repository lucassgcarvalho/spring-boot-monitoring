package br.com.forum.modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.forum.controller.dto.GenericDto;

@Entity
public class Topic extends AbstractBaseEntity {

	private static final long serialVersionUID = -6709413278237802795L;

	private String title;
	private String message;
	private LocalDateTime createDate = LocalDateTime.now();
	
	@Enumerated(value = EnumType.STRING)
	private StatusTopic status = StatusTopic.NOW_ANSWER;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Curse curse;
	
	@OneToMany(mappedBy = "topic")
	private List<Answer> listAnswer = new ArrayList<Answer>();

	public Topic() {
	}

	public Topic(String titulo, String mensagem, User autor, Curse curso) {
		this.title = titulo;
		this.message = mensagem;
		this.curse = curso;
		this.user = autor;
	}

	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = 31 * result + (this.getId() == null ? 0 : this.getId().hashCode());
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
		Topic other = (Topic) obj;
		return !(this.getId() == null ? other.getId() != null : !this.getId().equals(other.getId()));
	}

	public String getTitulo() {
		return this.title;
	}

	public void setTitulo(String titulo) {
		this.title = titulo;
	}

	public String getMensagem() {
		return this.message;
	}

	public void setMensagem(String mensagem) {
		this.message = mensagem;
	}

	public LocalDateTime getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(LocalDateTime dataCriacao) {
		this.createDate = dataCriacao;
	}

	public StatusTopic getStatus() {
		return this.status;
	}

	public void setStatus(StatusTopic status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User autor) {
		this.user = autor;
	}

	public Curse getCurse() {
		return this.curse;
	}

	public void setCurse(Curse curso) {
		this.curse = curso;
	}

	public List<Answer> getListAnswer() {
		return this.listAnswer;
	}

	public void setListAnswer(List<Answer> respostas) {
		this.listAnswer = respostas;
	}

	@Override
	public GenericDto parseDTO() {
		// TODO Auto-generated method stub
		return null;
	}
}
