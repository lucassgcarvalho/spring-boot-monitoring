/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.controller.dto.GenericDto
 *  br.com.forum.modelo.AbstractBaseEntity
 *  br.com.forum.modelo.Categoria
 *  br.com.forum.modelo.Curso
 *  javax.persistence.Entity
 *  javax.persistence.ManyToMany
 */
package br.com.forum.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import br.com.forum.controller.dto.GenericDto;

@Entity
public class Curse
extends AbstractBaseEntity {
    private static final long serialVersionUID = 9145044265178214768L;
    
    private String name;
    
    @ManyToMany
    private List<Category> listCategory;

    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = 31 * result + (this.getId() == null ? 0 : this.getId().hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Curse other = (Curse)obj;
        return !(this.getId() == null ? other.getId() != null : !this.getId().equals(other.getId()));
    }


    public List<Category> getListCategory() {
        return this.listCategory;
    }

    public void setListCategory(List<Category> categorias) {
        this.listCategory = categorias;
    }

    public GenericDto parseDTO() {
        return null;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

