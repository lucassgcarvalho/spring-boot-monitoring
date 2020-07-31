/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.modelo.AbstractBaseEntity
 *  br.com.forum.repository.AbstractBaseRepository
 *  br.com.forum.repository.AbstractBaseRepositoryImpl
 *  br.com.forum.service.GenericService
 *  br.com.forum.service.GenericServiceImpl
 *  javax.transaction.Transactional
 *  org.springframework.stereotype.Service
 */
package br.com.forum.service;

import br.com.forum.modelo.AbstractBaseEntity;
import br.com.forum.repository.AbstractBaseRepository;
import br.com.forum.repository.AbstractBaseRepositoryImpl;
import br.com.forum.service.GenericService;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class GenericServiceImpl<T extends AbstractBaseEntity>
extends AbstractBaseRepositoryImpl<T, Long>
implements GenericService<T> {
    public GenericServiceImpl(AbstractBaseRepository<T, Long> abstractBaseRepository) {
        super(abstractBaseRepository);
    }
}

