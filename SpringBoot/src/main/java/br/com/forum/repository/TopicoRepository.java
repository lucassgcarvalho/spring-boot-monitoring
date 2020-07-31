/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.modelo.Topico
 *  br.com.forum.repository.TopicoRepository
 *  org.springframework.data.domain.Page
 *  org.springframework.data.domain.Pageable
 *  org.springframework.data.jpa.repository.JpaRepository
 */
package br.com.forum.repository;

import br.com.forum.modelo.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository
extends JpaRepository<Topic, Long> {
    public Page<Topic> findByCurseName(String var1, Pageable var2);
}

