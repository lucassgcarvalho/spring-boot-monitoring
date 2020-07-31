/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.repository.CursoRepository
 *  br.com.forum.service.CursoServiceDirect
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package br.com.forum.service;

import br.com.forum.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceDirect {
    @Autowired
    private CursoRepository cursoRepository;

    public CursoRepository getRepository() {
        return this.cursoRepository;
    }
}

