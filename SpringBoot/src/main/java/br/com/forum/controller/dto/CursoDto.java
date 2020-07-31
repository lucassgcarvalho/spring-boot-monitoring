/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.dto.CategoriaDto
 *  br.com.forum.controller.dto.CursoDto
 *  br.com.forum.controller.dto.GenericDto
 *  br.com.forum.modelo.AbstractBaseEntity
 *  br.com.forum.modelo.Categoria
 *  br.com.forum.modelo.Curso
 *  br.com.forum.modelo.Usuario
 */
package br.com.forum.controller.dto;

import br.com.forum.controller.dto.CategoriaDto;
import br.com.forum.controller.dto.GenericDto;
import br.com.forum.modelo.AbstractBaseEntity;
import br.com.forum.modelo.Category;
import br.com.forum.modelo.Curse;
import br.com.forum.modelo.User;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CursoDto extends GenericDto {

    private String nome;

    private List<CategoriaDto> categorias;

    public CursoDto() {}

    public CursoDto(Curse curso, List<Category> categorias) {}

    public CursoDto(User usuario) {
        Objects.requireNonNull(usuario);
        this.nome = usuario.getName();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<CategoriaDto> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<CategoriaDto> categorias) {
        this.categorias = categorias;
    }

    public CursoDto parseFromEntity(AbstractBaseEntity entity) {
        Curse curso = (Curse) entity;
        this.setNome(curso.getName());
        this.setCategorias(curso.getListCategory()
                .stream()
                .map(CategoriaDto::newDtoParseFromEntity)
                .collect(Collectors.toList()));
        return this;
    }

    public static CursoDto newDtoParseFromEntity(AbstractBaseEntity entity) {
        CursoDto cursoDto = new CursoDto();
        Curse curso = (Curse) entity;
        cursoDto.setNome(curso.getName());
        cursoDto.setCategorias(curso.getListCategory()
                .stream()
                .map(CategoriaDto::newDtoParseFromEntity)
                .collect(Collectors.toList()));
        return cursoDto;
    }
}

