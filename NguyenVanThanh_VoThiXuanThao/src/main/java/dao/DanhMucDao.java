package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import model.DanhMuc;
import uti.EMF;

public class DanhMucDao {
	public List<DanhMuc> findAll() {
	    EntityManager em = EMF.getEMF().createEntityManager();
	    try {
	        TypedQuery<DanhMuc> q = em.createQuery("SELECT d FROM DanhMuc d", DanhMuc.class);
	        List<DanhMuc> list = q.getResultList();
	        return list;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        em.close();
	    }
	}
    public DanhMuc findById(String id) {
        EntityManager em = EMF.getEMF().createEntityManager();
        DanhMuc dm = null;
        try {
            dm = em.find(DanhMuc.class, id);
        } finally {
            em.close();
        }
        return dm;
    }

    public void insert(DanhMuc dm) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dm);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        em.close();
    }

    public void update(DanhMuc dm) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(dm);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        } 
            em.close();
    }

    public void delete(String id) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            DanhMuc dm = em.find(DanhMuc.class, id);
            if (dm != null) {
                em.getTransaction().begin();
                em.remove(dm);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        } 
            em.close();
    }
    public List<DanhMuc> search(String key) {
        EntityManager em = EMF.getEMF().createEntityManager();
        List<DanhMuc> list = null;

        try {
            TypedQuery<DanhMuc> query = em.createQuery(
                "SELECT d FROM DanhMuc d WHERE d.maDM LIKE :key OR d.tenDM LIKE :key",
                DanhMuc.class
            );
            query.setParameter("key", "%" + key + "%");
            list = query.getResultList();
        } finally {
            em.close();
        }
        return list;
    }

}