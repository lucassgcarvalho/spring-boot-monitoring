/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.modelo.AbstractBaseEntity
 *  br.com.forum.repository.AbstractBaseRepository
 *  org.springframework.data.jpa.repository.JpaRepository
 *  org.springframework.data.repository.NoRepositoryBean
 */
package br.com.forum.repository;

import br.com.forum.modelo.AbstractBaseEntity;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AbstractBaseRepository<T extends AbstractBaseEntity, ID extends Serializable>
extends JpaRepository<T, ID> {
    public T findByName(String var1);
}

