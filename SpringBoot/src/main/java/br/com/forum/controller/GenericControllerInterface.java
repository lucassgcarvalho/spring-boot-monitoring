package br.com.forum.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.forum.exceptions.DuplicidadeException;
import br.com.forum.modelo.AbstractBaseEntity;
import br.com.forum.service.GenericService;

public interface GenericControllerInterface<T extends AbstractBaseEntity> {
    GenericService<?> getGenericService();

    @PostMapping
    ResponseEntity<?> save(T var1);

    @PutMapping
    T update();

    @DeleteMapping
    T delete();

    @GetMapping
    ResponseEntity<?> findAll(@PageableDefault(sort={"nome"}, direction=Sort.Direction.DESC, page=0, size=10) Pageable var1) throws DuplicidadeException;
}

