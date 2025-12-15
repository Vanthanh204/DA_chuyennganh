package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import model.DonHang;
import uti.EMF;

public class DonHangDao {
	public List<DonHang> findAll() {
		EntityManager em = EMF.getEMF().createEntityManager();
        try {
	        TypedQuery<DonHang> q = em.createQuery("SELECT d FROM DonHang d", DonHang.class);
	        List<DonHang> list = q.getResultList();
	        return list;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    } finally {
	        em.close();
	    }
    }
	public DonHang findById(String id) {
        EntityManager em = EMF.getEMF().createEntityManager();
        DonHang dh = null;
        try {
            dh = em.find(DonHang.class, id);
        } finally {
            em.close();
        }
        return dh;
    }

    public void insert(DonHang dh) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(dh);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        em.close();
    }

    public void update(DonHang dh) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(dh);
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
            DonHang dh = em.find(DonHang.class, id);
            if (dh != null) {
                em.getTransaction().begin();
                em.remove(dh);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        } 
            em.close();
    }
     public List<DonHang> getByKhachHang(String maKH){
    	 EntityManager em= EMF.getEMF().createEntityManager();
    	 return em.createQuery("SELECT d FROM DonHang d WHERE d.khachHang.maKH = :maKH ORDER BY d.ngayTao DESC", DonHang.class).setParameter("maKH", maKH).getResultList();
    	 
     }
     public List<DonHang> search(String key) {
    	    EntityManager em = EMF.getEMF().createEntityManager();
    	    try {
    	        TypedQuery<DonHang> q = em.createQuery(
    	            "SELECT d FROM DonHang d " +
    	            "WHERE LOWER(d.maDH) LIKE :key " +
    	            "OR LOWER(d.khachHang.hoTen) LIKE :key " +
    	            "OR LOWER(d.khachHang.sdt) LIKE :key",
    	            DonHang.class
    	        );

    	        q.setParameter("key", "%" + key.toLowerCase() + "%");
    	        return q.getResultList();
    	    } finally {
    	        em.close();
    	    }
    	}
     public long getTongDoanhThu() {
    	    EntityManager em = EMF.getEMF().createEntityManager();
    	    try {
    	        TypedQuery<Long> q = em.createQuery(
    	            "SELECT SUM(c.soLuong * c.donGia) FROM ChiTietDonHang c",
    	            Long.class
    	        );
    	        Long result = q.getSingleResult();
    	        return result != null ? result : 0;
    	    } finally {
    	        em.close();
    	    }
    	}
     public long getSoLuongDon() {
    	    EntityManager em = EMF.getEMF().createEntityManager();
    	    try {
    	        TypedQuery<Long> q = em.createQuery(
    	            "SELECT COUNT(d) FROM DonHang d", Long.class
    	        );
    	        return q.getSingleResult();
    	    } finally {
    	        em.close();
    	    }
    	}


}