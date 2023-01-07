package io.github.lucasefdr.teste;

import io.github.lucasefdr.dao.ProdutoDAO;
import io.github.lucasefdr.domain.Produto;
import io.github.lucasefdr.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("iPhone");
        celular.setDescricao("XR");
        celular.setPreco(new BigDecimal("3200.00"));

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

        entityManager.getTransaction().begin();
        produtoDAO.salvar(celular);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
