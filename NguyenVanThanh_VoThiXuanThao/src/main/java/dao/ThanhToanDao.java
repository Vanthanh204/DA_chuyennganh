package dao;

import javax.persistence.EntityManager;

import model.ThanhToan;
import uti.EMF;

public class ThanhToanDao {

	

	public void insert(ThanhToan tt) {
		EntityManager em =EMF.getEMF().createEntityManager();
		em.getTransaction().begin();
		em.persist(tt);
		em.getTransaction().commit();
	}
}