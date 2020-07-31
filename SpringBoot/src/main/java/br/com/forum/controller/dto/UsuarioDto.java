/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.dto.UsuarioDto
 *  br.com.forum.modelo.Usuario
 */
package br.com.forum.controller.dto;

import br.com.forum.modelo.User;
import java.util.Objects;

public class UsuarioDto {
	
	private Long id;
    private String name;
    private String email;

    public UsuarioDto() {
    }

    public UsuarioDto(String nome, String email) {
        this.name = nome;
        this.email = email;
    }

    public UsuarioDto(User usuario) {
        Objects.requireNonNull(usuario);
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.email = usuario.getEmail();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

