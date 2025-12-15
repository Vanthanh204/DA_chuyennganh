package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.GioHang;
import model.GioHangChiTiet;
import model.GioHangChiTiet_ID;
import model.KhachHang;
import model.SanPham;
import uti.EMF;

public class GioHangDao {

    // Lấy giỏ hàng theo khách
    public GioHang getByMaKH(String maKH) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            TypedQuery<GioHang> q = em.createQuery(
                "SELECT g FROM GioHang g WHERE g.khachHang.maKH = :maKH",
                GioHang.class
            );
            q.setParameter("maKH", maKH);
            return q.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    // Tạo giỏ mới
    public GioHang createGH(KhachHang kh) {
        EntityManager em = EMF.getEMF().createEntityManager();
        try {
            em.getTransaction().begin();

            String maGH = "GH" + System.currentTimeMillis();

            GioHang gh = new GioHang();
            gh.setMaGH(maGH);
            gh.setKhachHang(kh);

            em.persist(gh);
            em.getTransaction().commit();

            return gh;

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return null;
        } finally {
            em.close();
        }
    }

    // Thêm sản phẩm vào giỏ hàng
    public boolean add(String maGH, String maSP) {

        EntityManager em = EMF.getEMF().createEntityManager();

        try {
            em.getTransaction().begin();

            GioHangChiTiet_ID id = new GioHangChiTiet_ID(maGH, maSP);
            GioHangChiTiet ct = em.find(GioHangChiTiet.class, id);

            if (ct == null) {

                GioHang gh = em.find(GioHang.class, maGH);
                SanPham sp = em.find(SanPham.class, maSP);

                ct = new GioHangChiTiet(gh, sp, 1);
                em.persist(ct);

            } else {
                ct.setSoLuong(ct.getSoLuong() + 1);
                em.merge(ct);
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

    // Xóa 1 sản phẩm khỏi giỏ
    public boolean deleteItem(String maGH, String maSP) {

        EntityManager em = EMF.getEMF().createEntityManager();

        try {
            em.getTransaction().begin();

            GioHangChiTiet ct = em.find(GioHangChiTiet.class, new GioHangChiTiet_ID(maGH, maSP));

            if (ct != null) {
                em.remove(ct);
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
