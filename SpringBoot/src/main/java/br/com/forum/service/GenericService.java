/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.modelo.AbstractBaseEntity
 *  br.com.forum.service.AbstractBaseService
 *  br.com.forum.service.GenericService
 */
package br.com.forum.service;

import br.com.forum.modelo.AbstractBaseEntity;
import br.com.forum.service.AbstractBaseService;

public interface GenericService<T extends AbstractBaseEntity> extends AbstractBaseService<T, Long> {
}

