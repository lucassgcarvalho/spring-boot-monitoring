package br.com.forum.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;

import br.com.forum.controller.dto.GenericDto;
import br.com.forum.modelo.AbstractBaseEntity;

public class HttpResponseUtils<T> {

    private T dto;
 
    public HttpResponseUtils(T dto) {
        this.dto = dto;
    }

    public ResponseEntity<?> status200(AbstractBaseEntity abstractBaseEntity) {
        GenericDto genericDto = ((GenericDto) this.dto).parseFromEntity(abstractBaseEntity);
        return ResponseEntity.ok().body(genericDto);
    }

    public synchronized ResponseEntity<?> status200(List<AbstractBaseEntity> listAbstractBaseEntity) {
        return ResponseEntity.ok().body(listAbstractBaseEntity
                .parallelStream()
                .map((entity)->{
                    return ((GenericDto) GenericUtils.getNewInstance(this.dto.getClass())).parseFromEntity(entity);
                })
                .collect(Collectors.toList()));
    }

    public ResponseEntity<?> status201(Object body) {
        return ResponseEntity.ok().body(body);
    }

    public ResponseEntity<?> status204(Object body) {
        return ResponseEntity.ok().body(body);
    }

    public ResponseEntity<?> status400(Object body) {
        return ResponseEntity.ok().body(body);
    }

    public ResponseEntity<?> status403(Object body) {
        return ResponseEntity.ok().body(body);
    }

    public ResponseEntity<?> status404(Object body) {
        return ResponseEntity.ok().body(body);
    }
}

