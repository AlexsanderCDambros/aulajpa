package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		/*
		//Criação dos objetos e inserção deles no banco de dados
		Pessoa p1 = new Pessoa(null,"Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null,"José Abram", "jose@gmail.com");
		Pessoa p3 = new Pessoa(null,"Pedro Santos", "pesantos123@gmail.com");
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		*/
		
		//Buscar registros do banco de dados
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		//Remover do banco de dados
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
				
		System.out.println("Pronto");
		em.close();
		emf.close();
	}

}
