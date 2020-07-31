package br.com.forum.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.forum.exceptions.DuplicidadeException;
import br.com.forum.modelo.AbstractBaseEntity;
import br.com.forum.service.GenericService;
import br.com.forum.utils.HttpResponseUtils;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
public class  GenericController<T extends AbstractBaseEntity, S> implements GenericControllerInterface<T> {
	
	@Autowired
	private GenericService<T> genericService;
	
	public GenericService<T> getGenericService() {
		return this.genericService;
	}

	public synchronized ResponseEntity<?> findAll(Pageable paginacao) throws DuplicidadeException {
		return new HttpResponseUtils(this.getNewInstance())
					.status200(genericService.findAll());
	}

	public synchronized ResponseEntity<?> save(T entity) {
		AbstractBaseEntity save = this.genericService.save(entity);
		return new HttpResponseUtils(this.getNewInstance()).status201(save);
	}

	public T update() {
		return null;
	}

	public T delete() {
		return null;
	}

	private synchronized Object getNewInstance() {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
		try {
			return ((Class) actualTypeArguments[1]).newInstance();
		} catch (IllegalAccessException | IllegalArgumentException | InstantiationException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
