package io.github.lucasefdr.dao;

import io.github.lucasefdr.domain.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
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

    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return entityManager.createQuery(jpql, Produto.class).setParameter("nome", nome).getResultList();
    }

    public List<Produto> buscarPorCategoria(String nomeDaCategoria) {
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :nomeDaCategoria";
        return entityManager.createQuery(jpql, Produto.class).setParameter("nomeDaCategoria", nomeDaCategoria).getResultList();
    }

    public BigDecimal buscarPreco(String nome, String descricao) {
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :nome AND p.descricao = :descricao";
        return entityManager.createQuery(jpql, BigDecimal.class).setParameter("nome", nome).setParameter("descricao", descricao).getSingleResult();
    }
}
