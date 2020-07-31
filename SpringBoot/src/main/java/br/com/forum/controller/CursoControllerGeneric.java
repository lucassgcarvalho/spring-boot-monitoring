package br.com.forum.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.forum.controller.dto.CursoDto;
import br.com.forum.exceptions.DuplicidadeException;
import br.com.forum.modelo.Curse;

//@RestController
//@RequestMapping(value = { "/testes" })
public class CursoControllerGeneric extends GenericController<Curse, CursoDto> {

	@GetMapping(value = { "/{nome}" })
	public ResponseEntity<?> findByName(@PathVariable String nome, Pageable paginacao) throws DuplicidadeException {
		return ResponseEntity.ok()
				.body( new CursoDto().parseFromEntity(super.getGenericService().findByNome(nome)) );
	}
}
