/*
 * Decompiled with CFR 0.145.
 *
 * Could not load the following classes:
 *  br.com.forum.controller.dto.UsuarioDto
 *  br.com.forum.controller.form.UsuarioForm
 *  br.com.forum.exceptions.DuplicidadeException
 *  br.com.forum.modelo.Usuario
 *  br.com.forum.repository.UsuarioRepository
 *  br.com.forum.service.UsuarioService
 *  javax.persistence.EntityNotFoundException
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.data.domain.Page
 *  org.springframework.data.domain.Pageable
 *  org.springframework.stereotype.Service
 */
package br.com.forum.service;

import br.com.forum.controller.dto.UsuarioDto;
import br.com.forum.controller.form.UsuarioForm;
import br.com.forum.exceptions.DuplicidadeException;
import br.com.forum.modelo.User;
import br.com.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDto save(UsuarioForm usuarioForm) throws DuplicidadeException {
        this.checkUsuarioDuplicado(usuarioForm.getEmail());
        return new UsuarioDto(this.usuarioRepository.save(usuarioForm.parse()));
    }

    private void checkUsuarioDuplicado(String email) throws DuplicidadeException {
        if (this.usuarioRepository.findByEmail(email).isPresent()) {
            throw new DuplicidadeException(String.format("Usu\u00e1rio [ %s ] j\u00e1 cadastrado.", email));
        }
    }

    public Page<UsuarioDto> findAll(Pageable paginacao) {
        return this.usuarioRepository.findAll(paginacao).map(UsuarioDto::new);
    }

    public UsuarioDto findByEmail(String email) throws EntityNotFoundException {
        Optional<UsuarioDto> usuario = this.usuarioRepository.findByEmail(email).map(UsuarioDto::new);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new EntityNotFoundException("Usu\u00e1rio n\u00e3o encontrado.");
    }

    public void deleteByEmail(String email) {
        this.usuarioRepository.deleteByEmail(email);
    }

    public UsuarioDto update(User usuarioEncontrado) {
        return new UsuarioDto(this.usuarioRepository.save(usuarioEncontrado));
    }

    public UsuarioDto update(String email, UsuarioForm usuarioForm) throws EntityNotFoundException {
        Objects.requireNonNull(usuarioForm, "Parâmetro [UsuarioForm] não pode ser nulo.");
        Objects.requireNonNull(email, "Parâmetro [email] não pode ser nulo.");
        User usuarioEncontrado = this.usuarioRepository.findByEmail(email).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado."));
        usuarioEncontrado.copiarDados(usuarioForm);
        return this.update(usuarioEncontrado);
    }
}

