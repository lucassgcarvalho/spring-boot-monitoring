/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.form.UsuarioForm
 *  br.com.forum.modelo.Usuario
 *  br.com.forum.utils.EncryptUtils
 *  javax.validation.constraints.Email
 *  javax.validation.constraints.NotBlank
 *  javax.validation.constraints.NotNull
 *  javax.validation.constraints.Size
 *  org.springframework.security.crypto.password.PasswordEncoder
 */
package br.com.forum.controller.form;

import br.com.forum.modelo.User;
import br.com.forum.utils.EncryptUtils;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UsuarioForm {
    private EncryptUtils encryptUtils;
    @NotNull
    @Size(min=3, max=255)
    @NotBlank
    private String nome;
    @NotNull
    @Email
    @Size(min=10, max=100)
    @NotBlank
    private String email;
    @NotNull
    @Size(min=6, max=20)
    @NotBlank
    private String senha;

    public User parse() {
        this.encryptUtils = new EncryptUtils(null);
        User usuario = new User();
        usuario.setName(this.nome);
        usuario.setSenha(this.encryptUtils.encryptPassword(this.senha));
        usuario.setEmail(this.email);
        return usuario;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return this.senha;
    }

    public String getSenhaCriptografada() {
        return new EncryptUtils(null).encryptPassword(this.senha);
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

