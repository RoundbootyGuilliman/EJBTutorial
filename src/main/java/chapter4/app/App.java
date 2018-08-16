package chapter4.app;

import chapter4.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class App {
	
	public static void main(String[] args) {
		
		Book book = new Book("567", 12.5F, "The Hitchhiker's Guide to the Galaxy",
				"1-84023-742-2", 354, false);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04pu");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(book);
		tx.commit();
		
		book = em.createNamedQuery("findH2G2", Book.class).getSingleResult();
		
		em.close();
		emf.close();
		
		System.out.println(book.getDescription());
	}
}
