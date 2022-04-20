package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.model.Register;
import br.com.fiap.model.Setup;

public class RegisterDAO {
	
	EntityManagerFactory factory = 
			Persistence.createEntityManagerFactory("progamer-persistence-unit");
	EntityManager manager = factory.createEntityManager();
	
	public void create(Register register) {
		manager.getTransaction().begin();
		manager.persist(register);
		manager.getTransaction().commit();
		
		manager.clear();
		
	}

	public List<Register> listAll() {

		return manager
				.createQuery("SELECT s FROM Register s", Register.class)
				.getResultList();
		
	}

}
