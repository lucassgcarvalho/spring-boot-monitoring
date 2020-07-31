/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.UsuarioController
 *  br.com.forum.controller.dto.UsuarioDto
 *  br.com.forum.controller.form.UsuarioForm
 *  br.com.forum.exceptions.DuplicidadeException
 *  br.com.forum.service.UsuarioService
 *  javax.transaction.Transactional
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.data.domain.Page
 *  org.springframework.data.domain.Pageable
 *  org.springframework.data.domain.Sort
 *  org.springframework.data.domain.Sort$Direction
 *  org.springframework.data.web.PageableDefault
 *  org.springframework.http.HttpStatus
 *  org.springframework.http.ResponseEntity
 *  org.springframework.web.bind.annotation.DeleteMapping
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package br.com.forum.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.forum.controller.form.UsuarioForm;
import br.com.forum.exceptions.DuplicidadeException;
import br.com.forum.service.UsuarioService;

@RestController
@RequestMapping(value={"/usuarios"})
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> createUser(@RequestBody UsuarioForm usuarioForm) throws DuplicidadeException {
        return ResponseEntity.ok((Object)this.usuarioService.save(usuarioForm));
    }

    @GetMapping
    public ResponseEntity<?> getUser(@PageableDefault(sort={"nome"}, direction=Sort.Direction.DESC, page=0, size=10) Pageable paginacao) throws DuplicidadeException {
        return ResponseEntity.ok((Object)this.usuarioService.findAll(paginacao));
    }

    @GetMapping(value={"/{email}"})
    public ResponseEntity<?> getUserByEmail(@PathVariable String email) throws DuplicidadeException {
        return ResponseEntity.ok((Object)this.usuarioService.findByEmail(email));
    }

    @DeleteMapping(value={"/{email}"})
    @Transactional
    public ResponseEntity<?> deleteUserByEmail(@PathVariable String email) {
        this.usuarioService.deleteByEmail(email);
        return ResponseEntity.status((HttpStatus)HttpStatus.NO_CONTENT).build();
    }

    @PutMapping(value={"/{email}"})
    @Transactional
    public ResponseEntity<?> updateUser(@PathVariable String email, @RequestBody UsuarioForm usuarioForm) {
        return ResponseEntity.ok().body((Object)this.usuarioService.update(email, usuarioForm));
    }
}

