package io.github.lucasefdr.dao;

import io.github.lucasefdr.domain.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDAO {
    private final EntityManager entityManager;

    public CategoriaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Categoria categoria) {
        entityManager.persist(categoria);
    }
}
