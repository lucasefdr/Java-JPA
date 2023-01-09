package io.github.lucasefdr.teste;

import io.github.lucasefdr.dao.CategoriaDAO;
import io.github.lucasefdr.dao.ProdutoDAO;
import io.github.lucasefdr.domain.Categoria;
import io.github.lucasefdr.domain.Produto;
import io.github.lucasefdr.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager entityManager = JPAUtil.getEntityManager();
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

        Produto produto = produtoDAO.buscarPorId(1L);

        System.out.println(produto.getNome());
        System.out.println(produto.getDescricao());
        System.out.println(produto.getPreco());

        System.out.println();

        System.out.println("Retornando todos os produtos: ");
        List<Produto> produtos = produtoDAO.buscarTodos();

        produtos.forEach((p) -> System.out.println(p.getNome()));

        System.out.println("Retornando produtos passando parâmetro: ");
        List<Produto> iphones = produtoDAO.buscarPorNome("iPhone");

        iphones.forEach((p) -> System.out.println(p.getNome()));

        System.out.println("Retornando produtos por categoria: ");
        List<Produto> celulares = produtoDAO.buscarPorCategoria("CELULARES");

        celulares.forEach((p) -> System.out.println(p.getNome()));

        System.out.println("Retornando preco de um produto: ");
        BigDecimal precoIPhone11 = produtoDAO.buscarPreco("iPhone", "11");

        System.out.println("Preço iPhone 11: R$ " + precoIPhone11);
    }

    public static void cadastrarProduto() {
        Categoria celulares = new Categoria("CELULARES");

        Produto celular = new Produto("iPhone", "11", new BigDecimal("3474.00"), celulares);

        EntityManager entityManager = JPAUtil.getEntityManager();
        CategoriaDAO categoriaDAO = new CategoriaDAO(entityManager);
        ProdutoDAO produtoDAO = new ProdutoDAO(entityManager);

        entityManager.getTransaction().begin();
        categoriaDAO.salvar(celulares);
        produtoDAO.salvar(celular);

        entityManager.flush();
        entityManager.clear();

        celular = entityManager.merge(celular);
        celular.setPreco(new BigDecimal("3200.00"));

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
