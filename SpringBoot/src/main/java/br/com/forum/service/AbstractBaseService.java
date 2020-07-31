/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.modelo.AbstractBaseEntity
 *  br.com.forum.service.AbstractBaseService
 */
package br.com.forum.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import br.com.forum.modelo.AbstractBaseEntity;

public interface AbstractBaseService<T extends AbstractBaseEntity, ID extends Serializable> {
	
    T save(T entity);
    
    T save(Object form);

    List<T> findAll();

    Optional<T> findById(ID var1);

    T update(T entity);

    T updateById(T entity, ID id);

    void delete(T entity);

    void deleteById(ID id);

    T findByNome(String nome);
}

