package io.github.lucasefdr.dao;

import io.github.lucasefdr.domain.Produto;

import javax.persistence.EntityManager;
import java.util.List;

public class ProdutoDAO {
    private final EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Produto produto) {
        entityManager.persist(produto);
    }

    public void deletar(Produto produto) {
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
    }

    public Produto buscarPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }
}
