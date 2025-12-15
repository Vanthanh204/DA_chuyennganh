package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.Anh;
import uti.EMF;

public class AnhDao {
	public List<Anh> findall(){
		EntityManager em=EMF.getEMF().createEntityManager();
		try {
			TypedQuery<Anh> q=em.createQuery("select a from Anh a", Anh.class);
			return q.getResultList();
		} catch (Exception e) {
			return null;
			// TODO: handle exception
		}
	}

}
