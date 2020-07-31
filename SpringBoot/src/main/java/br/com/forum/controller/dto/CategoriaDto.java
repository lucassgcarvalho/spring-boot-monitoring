package br.com.forum.controller.dto;

import br.com.forum.modelo.AbstractBaseEntity;
import br.com.forum.modelo.Category;

public class CategoriaDto extends GenericDto {

    private String nome;

    public static CategoriaDto newDtoParseFromEntity(AbstractBaseEntity entity) {
        CategoriaDto categoriaDto = new CategoriaDto();
        Category categoria = (Category) entity;
        categoriaDto.nome = categoria.getName();
        return categoriaDto;
    }

    @Override
    public GenericDto parseFromEntity(AbstractBaseEntity abstractBaseEntity) {
        return null;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

