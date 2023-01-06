package io.github.lucasefdr.teste;

import io.github.lucasefdr.domain.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("iPhone");
        celular.setDescricao("XR");
        celular.setPreco(new BigDecimal("3200.00"));

        // Usando o design pattern FACTORY
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");

        // Criando um EntityManager através do FACTORY
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
