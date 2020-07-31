/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.modelo.AbstractBaseEntity
 *  br.com.forum.repository.AbstractBaseRepository
 *  br.com.forum.repository.AbstractBaseRepositoryImpl
 *  br.com.forum.service.AbstractBaseService
 *  javax.transaction.Transactional
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Repository
 */
package br.com.forum.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.forum.modelo.AbstractBaseEntity;
import br.com.forum.service.AbstractBaseService;

//@Repository
//@Transactional
public class AbstractBaseRepositoryImpl<T extends AbstractBaseEntity, ID extends Serializable> implements AbstractBaseService<T, ID> {
	
    private AbstractBaseRepository<T, ID> abstractBaseRepository;

    @Autowired 
    public AbstractBaseRepositoryImpl(AbstractBaseRepository<T, ID> abstractBaseRepository) {
        this.abstractBaseRepository = abstractBaseRepository;
    }

    public T save(T entity) {
        return (T)((AbstractBaseEntity) this.abstractBaseRepository.save(entity));
    }

    public List<T> findAll() {
        return this.abstractBaseRepository.findAll();
    }

    public Optional<T> findById(ID entityId) {
        return this.abstractBaseRepository.findById(entityId);
    }

    public T update(T entity) {
        return (T)((AbstractBaseEntity)this.abstractBaseRepository.save(entity));
    }

    public T updateById(T entity, ID entityId) {
        Optional optional = this.abstractBaseRepository.findById(entityId);
        if (optional.isPresent()) {
            return (T)((AbstractBaseEntity)this.abstractBaseRepository.save(entity));
        }
        return null;
    }

    public void delete(T entity) {
        this.abstractBaseRepository.delete(entity);
    }

    public void deleteById(ID entityId) {
        this.abstractBaseRepository.deleteById(entityId);
    }

    public T findByNome(String nome) {
        return (T)this.abstractBaseRepository.findByName(nome);
    }

	@Override
	public T save(Object form) {
		// TODO Auto-generated method stub
		return null;
	}
}

