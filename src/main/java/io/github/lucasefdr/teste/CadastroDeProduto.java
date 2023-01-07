package io.github.lucasefdr.teste;

import io.github.lucasefdr.dao.CategoriaDAO;
import io.github.lucasefdr.dao.ProdutoDAO;
import io.github.lucasefdr.domain.Categoria;
import io.github.lucasefdr.domain.Produto;
import io.github.lucasefdr.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");


        Produto celular = new Produto("iPhone", "11", new BigDecimal("3474.00"), celulares);

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

        entityManager.getTransaction().begin();
        categoriaDAO.salvar(celulares);
        produtoDAO.salvar(celular);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
