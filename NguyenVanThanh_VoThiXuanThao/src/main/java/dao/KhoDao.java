package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Kho;
import uti.EMF;

public class KhoDao {
	public List<Kho> findAll() {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            return em.createQuery("SELECT k FROM Kho k", Kho.class).getResultList();
        } finally {
            em.close();
        }
    }
    public Kho findById(String maKho) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            return em.find(Kho.class, maKho);
        } finally {
            em.close();
        }
    }
    public boolean tangTon(String maSP, int soLuong) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TypedQuery<Kho> q = em.createQuery(
                "SELECT k FROM Kho k WHERE k.sanPham.maSP = :maSP", Kho.class);
            q.setParameter("maSP", maSP);
            Kho kho = q.getSingleResult();
            if (kho == null) return false;
            kho.setSoLuongTon(kho.getSoLuongTon() + soLuong);
            kho.setNgayCapNhat(new java.util.Date());

            em.merge(kho);
            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            return false;
        } finally {
            em.close();
        }
    }
    public boolean giamTon(String maSP, int soLuong) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            TypedQuery<Kho> q = em.createQuery(
                "SELECT k FROM Kho k WHERE k.sanPham.maSP = :maSP", Kho.class);
            q.setParameter("maSP", maSP);
            Kho kho = q.getSingleResult();
            if (kho == null) return false;

            int tonMoi = kho.getSoLuongTon() - soLuong;
            if (tonMoi < 0) tonMoi = 0;

            kho.setSoLuongTon(tonMoi);
            kho.setNgayCapNhat(new java.util.Date());

            em.merge(kho);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            return false;
        } finally {
            em.close();
        }
    }
    public boolean save(Kho kho) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(kho);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            return false;

        } finally {
            em.close();
        }
    }
    public boolean delete(String maKho) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            Kho kho = em.find(Kho.class, maKho);
            if (kho == null) return false;

            tx.begin();
            em.remove(kho);
            tx.commit();
            return true;

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            return false;

        } finally {
            em.close();
        }
    }
    public List<Kho> search(String key) {
        EntityManager em = EMF.getEMF().createEntityManager();

        try {
            TypedQuery<Kho> q = em.createQuery(
                "SELECT k FROM Kho k " +
                "WHERE LOWER(k.maKho) LIKE :key " +
                "OR LOWER(k.sanPham.maSP) LIKE :key " +
                "OR LOWER(k.sanPham.tenSP) LIKE :key",
                Kho.class
            );
            q.setParameter("key", "%" + key.toLowerCase() + "%");
            return q.getResultList();

        } finally {
            em.close();
        }
    }


}
