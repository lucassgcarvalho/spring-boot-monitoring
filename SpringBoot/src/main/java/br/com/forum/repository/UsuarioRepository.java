/*
 * Decompiled with CFR 0.145.
 *
 * Could not load the following classes:
 *  br.com.forum.modelo.Usuario
 *  br.com.forum.repository.UsuarioRepository
 *  org.springframework.data.jpa.repository.JpaRepository
 */
package br.com.forum.repository;

import br.com.forum.modelo.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String var1);

    void deleteByEmail(String var1);
}

