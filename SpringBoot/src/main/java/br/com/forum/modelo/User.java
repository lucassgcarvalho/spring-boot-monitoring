/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.form.UsuarioForm
 *  br.com.forum.modelo.GenericEntity
 *  br.com.forum.modelo.Perfil
 *  br.com.forum.modelo.Usuario
 *  javax.persistence.Entity
 *  javax.persistence.FetchType
 *  javax.persistence.GeneratedValue
 *  javax.persistence.GenerationType
 *  javax.persistence.Id
 *  javax.persistence.ManyToMany
 *  org.springframework.security.core.GrantedAuthority
 *  org.springframework.security.core.userdetails.UserDetails
 */
package br.com.forum.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.forum.controller.form.UsuarioForm;

@Entity
public class User implements UserDetails, GenericEntity {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String password;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Perfil> listPerfil = new ArrayList();

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
		User other = (User) obj;
		return !(this.id == null ? other.id != null : !this.id.equals(other.id));
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getSenha() {
		return this.password;
	}

	public void setSenha(String senha) {
		this.password = senha;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.listPerfil;
	}

	public String getPassword() {
		return this.password;
	}

	public String getUsername() {
		return this.email;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}

	public void copiarDados(UsuarioForm usuarioForm) {
		this.setEmail(usuarioForm.getEmail());
		this.setName(usuarioForm.getNome());
		this.setSenha(usuarioForm.getSenhaCriptografada());
	}
}
