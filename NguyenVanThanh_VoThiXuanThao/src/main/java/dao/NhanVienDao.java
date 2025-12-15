package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.NhanVien;
import uti.EMF;

public class NhanVienDao {
    public List<NhanVien> findAll() {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            TypedQuery<NhanVien> q =
                em.createQuery("SELECT nv FROM NhanVien nv", NhanVien.class);
            return q.getResultList();
        } finally {
            em.close();
        }
    }
    public NhanVien findById(String maNV) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            return em.find(NhanVien.class, maNV);
        } finally {
            em.close();
        }
    }
    public NhanVien login(String sdt, String mk) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            TypedQuery<NhanVien> q = em.createQuery(
                "SELECT nv FROM NhanVien nv WHERE nv.sdt = :sdt AND nv.mk = :mk",
                NhanVien.class
            );
            q.setParameter("sdt", sdt);
            q.setParameter("mk", mk);
            List<NhanVien> list = q.getResultList();
            return list.isEmpty() ? null : list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    public boolean existsPhone(String sdt) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            long count = em.createQuery(
                "SELECT COUNT(nv) FROM NhanVien nv WHERE nv.sdt = :sdt",
                Long.class
            ).setParameter("sdt", sdt).getSingleResult();

            return count > 0;

        } finally {
            em.close();
        }
    }
    public boolean insert(NhanVien nv) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(nv);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;

        } finally {
            em.close();
        }
    }

    public boolean update(NhanVien nvNew) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            NhanVien nvOld = em.find(NhanVien.class, nvNew.getMaNV());
            if (nvOld == null) return false;
            nvOld.setHoTen(nvNew.getHoTen());
            nvOld.setMk(nvNew.getMk());
            nvOld.setSdt(nvNew.getSdt());
            nvOld.setTrangThai(nvNew.getTrangThai());
            nvOld.setVaiTro(nvNew.getVaiTro());
            nvOld.setEmail(nvNew.getEmail());
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    public boolean delete(String maNV) {
        EntityManager em = EMF.getEMF().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            NhanVien nv = em.find(NhanVien.class, maNV);
            if (nv == null) return false;
            tx.begin();
            em.remove(nv);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }
    public List<NhanVien> search(String key) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            TypedQuery<NhanVien> q = em.createQuery(
                "SELECT nv FROM NhanVien nv " +
                "WHERE nv.maNV LIKE :key " +
                "OR nv.hoTen LIKE :key " +
                "OR nv.sdt LIKE :key",
                NhanVien.class
            );
            q.setParameter("key", "%" + key + "%");
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}
