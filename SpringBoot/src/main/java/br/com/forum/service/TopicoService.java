/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.repository.TopicoRepository
 *  br.com.forum.service.TopicoService
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package br.com.forum.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.forum.controller.form.TopicoForm;
import br.com.forum.modelo.Curse;
import br.com.forum.modelo.Topic;
import br.com.forum.modelo.User;
import br.com.forum.repository.CursoRepository;
import br.com.forum.repository.TopicoRepository;
import br.com.forum.repository.UsuarioRepository;

@Service
public class TopicoService implements AbstractBaseService<Topic, Long> {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Topic save(Object form) {
		TopicoForm topicoForm = (TopicoForm) form; 
		
		Optional<User> usuario = usuarioRepository.findByEmail(topicoForm.getEmail());
		usuario.orElseThrow( () -> new EntityNotFoundException("Usuário não encontrado.") );
		
		Curse curso = cursoRepository.findByName(topicoForm.getAbout());
		if(curso != null) {
			return this.topicoRepository.save(new Topic(topicoForm.getTitle(), topicoForm.getMessage(), usuario.get(), curso));
		}
		
		throw new EntityNotFoundException("Curso não encontrado.");
	}

	@Override
	public Topic save(Topic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Topic> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Topic> findById(Long var1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Topic update(Topic entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Topic updateById(Topic entity, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Topic entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Topic findByNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	public TopicoRepository getTopicoRepository() {
		return topicoRepository;
	}

}
