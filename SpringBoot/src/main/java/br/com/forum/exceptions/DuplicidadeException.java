/*
 * Decompiled with CFR 0.145.
 * 
 * Could not load the following classes:
 *  br.com.forum.exceptions.DuplicidadeException
 */
package br.com.forum.exceptions;

public class DuplicidadeException
extends Exception {
    private static final long serialVersionUID = -5542627657418159227L;

    public DuplicidadeException(Exception e) {
        super(e);
    }

    public DuplicidadeException(String message) {
        super(message);
    }

    public DuplicidadeException(String message, Exception e) {
        super(message, e);
    }

    public DuplicidadeException() {
    }
}

