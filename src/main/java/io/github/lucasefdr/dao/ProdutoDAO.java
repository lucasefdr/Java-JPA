package io.github.lucasefdr.dao;

import io.github.lucasefdr.domain.Produto;

import javax.persistence.EntityManager;

public class ProdutoDAO {
    private final EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Produto produto) {
        entityManager.persist(produto);
    }

    public void deletar(Produto produto) {
        entityManager.remove(produto);
    }
}
