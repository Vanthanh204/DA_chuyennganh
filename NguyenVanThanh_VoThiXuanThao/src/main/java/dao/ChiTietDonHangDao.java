package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.ChiTietDonHang;
import uti.EMF;

public class ChiTietDonHangDao {

    public List<ChiTietDonHang> getByMaDH(String maDH) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            TypedQuery<ChiTietDonHang> q = em.createQuery(
                "SELECT c FROM ChiTietDonHang c WHERE c.donHang.maDH = :mad",
                ChiTietDonHang.class
            );
            q.setParameter("mad", maDH);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    public void insert(ChiTietDonHang ct) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(ct);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public void deleteByMaDH(String maDH) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery(
                "DELETE FROM ChiTietDonHang c WHERE c.donHang.maDH = :mad"
            )
            .setParameter("mad", maDH)
            .executeUpdate();

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public long getTongSanPhamBan() {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            TypedQuery<Long> q = em.createQuery(
                "SELECT SUM(c.soLuong) FROM ChiTietDonHang c",
                Long.class
            );
            Long result = q.getSingleResult();
            return result != null ? result : 0;
        } finally {
            em.close();
        }
    }
}
