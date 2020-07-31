/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.modelo.AbstractBaseEntity
 *  br.com.forum.modelo.Curso
 *  br.com.forum.repository.AbstractBaseRepository
 *  br.com.forum.repository.CursoRepository
 *  org.springframework.stereotype.Repository
 */
package br.com.forum.repository;

import org.springframework.stereotype.Repository;

import br.com.forum.modelo.Curse;

@Repository
public interface CursoRepository
extends AbstractBaseRepository<Curse, Long> {
	
    public Curse findByName(String name);
}

