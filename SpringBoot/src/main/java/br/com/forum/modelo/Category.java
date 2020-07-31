/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.dto.GenericDto
 *  br.com.forum.modelo.AbstractBaseEntity
 *  br.com.forum.modelo.Categoria
 *  javax.persistence.Entity
 */
package br.com.forum.modelo;

import javax.persistence.Entity;

import br.com.forum.controller.dto.GenericDto;

@Entity
public class Category
extends AbstractBaseEntity {
    private static final long serialVersionUID = -2757916425777992601L;
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public GenericDto parseDTO() {
        return null;
    }
}

