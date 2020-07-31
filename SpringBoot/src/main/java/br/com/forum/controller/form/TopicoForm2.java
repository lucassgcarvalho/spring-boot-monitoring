/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.form.TopicoForm
 *  br.com.forum.modelo.Curso
 *  br.com.forum.modelo.Topico
 *  br.com.forum.repository.CursoRepository
 *  br.com.forum.service.CursoServiceDirect
 *  javax.validation.constraints.NotEmpty
 *  javax.validation.constraints.NotNull
 *  org.hibernate.validator.constraints.Length
 */
package br.com.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class TopicoForm2 {
    
	@NotNull
    @NotEmpty
    @Length(min=5)
    private String title;
    
    @NotNull
    @NotEmpty
    @Length(min=10)
    private String message;
    
    @NotNull
    @NotEmpty
    private String about;
    
    @NotNull
    @NotEmpty
    private String emailAuthor;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEmailAuthor() {
		return emailAuthor;
	}

	public void setEmailAuthor(String emailAuthor) {
		this.emailAuthor = emailAuthor;
	}
}

