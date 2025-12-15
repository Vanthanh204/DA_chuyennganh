package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import model.SanPham;
import uti.EMF;


public class SanPhamDao {
	public List<SanPham> findAll(){
		EntityManager em = EMF.getEMF().createEntityManager();
		List<SanPham> list= null;
		try {
			TypedQuery<SanPham> query = 
					em.createQuery("SELECT s FROM SanPham s",SanPham.class);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	public List<SanPham> getByDanhMuc(String maDM) {
	    EntityManager em = EMF.getEMF().createEntityManager();
	    List<SanPham> list = null;

	    try {
	        TypedQuery<SanPham> query = em.createQuery(
	            "SELECT s FROM SanPham s WHERE s.danhMuc.maDM = :maDM",
	            SanPham.class
	        );

	        query.setParameter("maDM", maDM);
	        list = query.getResultList();

	    } finally {
	        em.close();
	    }

	    return list;
	}
	public SanPham findById(String id)  {
		EntityManager em = EMF.getEMF().createEntityManager();
		SanPham sp = null;
		try {
			sp = em.find(SanPham.class, id);
			if(sp!=null && sp.getDanhMuc()!= null) {
				sp.getDanhMuc().getTenDM();
			}
		} finally {
			 em.close();
		}
		return sp;
	}
	public void insert (SanPham sp) {
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(sp);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			 if (em.getTransaction().isActive())
	                em.getTransaction().rollback();
	            e.printStackTrace();
		} em.close();
	}
	public void update(SanPham sp) {
		EntityManager em = EMF.getEMF().createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(sp);
			em.getTransaction().commit();
			
		} catch (Exception e) {
			 if (em.getTransaction().isActive())
	                em.getTransaction().rollback();
	            e.printStackTrace();
		} em.close();
	}
	public void delete(String id) {
        EntityManager em = EMF.getEMF().createEntityManager();

        try {
            SanPham sp = em.find(SanPham.class, id);
            if (sp != null) {
                em.getTransaction().begin();
                em.remove(sp);
                em.getTransaction().commit();
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();

        } em.close();
    }
	public List<SanPham> search(String key) {
        EntityManager em = EMF.getEMF().createEntityManager();
        List<SanPham> list = null;
        try {
            TypedQuery<SanPham> query =
                em.createQuery(
                    "SELECT s FROM SanPham s LEFT JOIN FETCH s.danhMuc "
                  + "WHERE s.maSP LIKE :k OR s.tenSP LIKE :k",
                    SanPham.class
                );
            query.setParameter("k", "%" + key + "%");
            list = query.getResultList();
        } finally {
            em.close();
        }

        return list;
    }

}