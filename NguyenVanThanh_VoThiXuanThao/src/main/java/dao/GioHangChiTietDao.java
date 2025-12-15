package dao;

import java.util.List;
import javax.persistence.EntityManager;

import model.GioHang;
import model.GioHangChiTiet;
import model.GioHangChiTiet_ID;
import model.SanPham;
import uti.EMF;

public class GioHangChiTietDao {
    public GioHangChiTiet find(String maGH, String maSP) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            return em.find(GioHangChiTiet.class, new GioHangChiTiet_ID(maGH, maSP));
        } finally {
            em.close();
        }
    }
    public List<GioHangChiTiet> getByMaGH(String maGH) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            return em.createQuery(
                "SELECT ct FROM GioHangChiTiet ct WHERE ct.gioHang.maGH = :maGH",
                GioHangChiTiet.class
            ).setParameter("maGH", maGH)
             .getResultList();
        } finally {
            em.close();
        }
    }
    public boolean add(String maGH, String maSP) {
        EntityManager em = EMF.getEMF().createEntityManager();
        
        try {
            em.getTransaction().begin();
            GioHangChiTiet existing = em.find(GioHangChiTiet.class, new GioHangChiTiet_ID(maGH, maSP));
            if (existing == null) {
                GioHang gh = em.find(GioHang.class, maGH);
                SanPham sp = em.find(SanPham.class, maSP);
                GioHangChiTiet item = new GioHangChiTiet(gh, sp, 1);
                em.persist(item);
            } else {
                existing.setSoLuong(existing.getSoLuong() + 1);
                em.merge(existing);
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;

        } finally {
            em.close();
        }
    }
    public boolean updateSoLuong(String maGH, String maSP, int newSL) {

        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            GioHangChiTiet item = em.find(GioHangChiTiet.class, new GioHangChiTiet_ID(maGH, maSP));
            if (item == null) return false;
            if (newSL <= 0) {
                em.remove(item);
            } else {
                item.setSoLuong(newSL);
                em.merge(item);
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }
    public boolean delete(String maGH, String maSP) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();
            GioHangChiTiet item = em.find(GioHangChiTiet.class, new GioHangChiTiet_ID(maGH, maSP));
            if (item != null) {
            	item.getGioHang().getDsChiTiet().remove(item);
                em.remove(item);
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
    }
}
