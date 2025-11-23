package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.SanPham;
import uti.EMF;

public class SanPhamDao {

	private EntityManager em;
	public SanPhamDao() {
		em=EMF.getEntityManagerFactory().createEntityManager();
	}
	public List<SanPham> getall(){
		try {
			TypedQuery<SanPham> q= em.createQuery("SELECT sp FROM SanPham sp",SanPham.class);
			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}
}
