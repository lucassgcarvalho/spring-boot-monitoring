package br.com.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.forum.controller.dto.DetalhesTopicoDto;
import br.com.forum.controller.dto.TopicoDto;
import br.com.forum.controller.form.AtualizacaoTopicoForm;
import br.com.forum.controller.form.TopicoForm;
import br.com.forum.modelo.Topic;
import br.com.forum.modelo.User;
import br.com.forum.service.TopicoService;

@RestController
@RequestMapping(value = {"/topics"})
public class TopicosController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping 
    //@Cacheable(value = {"listaDeTopicos"})
    public Page<TopicoDto> lista(@RequestParam(required = false) String nomeCurso, 
    			@PageableDefault(sort = {"createDate"}, direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        if (nomeCurso == null) {
            Page<Topic> topicos = this.topicoService.getTopicoRepository().findAll(paginacao);
            return TopicoDto.converter(topicos);
        }
        Page<Topic> topicos = this.topicoService.getTopicoRepository().findByCurseName(nomeCurso, paginacao);
        return TopicoDto.converter(topicos);
    }
	
    @PostMapping
    @Transactional
    //@CacheEvict(value = {"listaDeTopicos"}, allEntries = true)
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
    	Topic topico = this.topicoService.save(form);
    	
		URI uri = uriBuilder.path("/topicos/{id}")
							.buildAndExpand(topico.getId())
							.toUri();
		
		return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @GetMapping(value = {"/{id}"})
    public ResponseEntity<DetalhesTopicoDto> detalhar(@PathVariable Long id) {
        Optional<Topic> topico = this.topicoService.getTopicoRepository().findById(id);
        if (topico.isPresent()) {
            return ResponseEntity.ok((DetalhesTopicoDto) new DetalhesTopicoDto((Topic) topico.get()));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping(value = {"/mapa"})
    public ResponseEntity<DetalhesTopicoDto> mapa(@PageableDefault(sort = {"dataCriacao"}, direction = Sort.Direction.DESC, page = 0, size = 3000) Pageable paginacao) {
    	
    	List<Topic> findAll = this.topicoService.getTopicoRepository().findAll();
    	 
//    	Map<Usuario, Usuario> collect = findAll.stream()
//        	.map((topico)->{
//        		return topico.getAutor();
//        	}).collect(Collectors.toMap( (topico) -> topico, (topico) -> topico));
//        
//        
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = {"/{id}"})
    @Transactional
    //@CacheEvict(value = {"listaDeTopicos"}, allEntries = true)
    public ResponseEntity<TopicoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        Optional<Topic> optional = this.topicoService.getTopicoRepository().findById(id);
        if (optional.isPresent()) {
            Topic topico = form.atualizar(id, this.topicoService.getTopicoRepository());
            return ResponseEntity.ok((TopicoDto) new TopicoDto(topico));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = {"/{id}"})
    @Transactional
   // @CacheEvict(value = {"listaDeTopicos"}, allEntries = true)
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Topic> optional = this.topicoService.getTopicoRepository().findById(id);
        if (optional.isPresent()) {
            this.topicoService.getTopicoRepository().deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}

