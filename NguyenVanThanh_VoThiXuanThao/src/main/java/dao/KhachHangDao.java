package dao;

import java.sql.PreparedStatement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import model.KhachHang;
import model.SanPham;
import uti.EMF;

public class KhachHangDao {

	private EntityManager em;
	public	KhachHangDao () {
		em=EMF.getEMF().createEntityManager();
	}
	public KhachHang login(String sdt, String mk) {
		try {
			TypedQuery<KhachHang> q= em.createQuery("SELECT kh FROM KhachHang kh WHERE kh.sdt = :sdt AND kh.mk = :mk", KhachHang.class);
			q.setParameter("sdt",sdt);
			q.setParameter("mk", mk);
			return q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	public List<KhachHang> findAll(){
			
			List<KhachHang> list= em.createQuery("from KhachHang").getResultList();
			em.close();
			return list;
	}

	public boolean register(KhachHang kh) {
		try {
			em.getTransaction().begin();
			em.persist(kh);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return false;
			
		}
	}
	public KhachHang findById(String maKH) {
	    return em.find(KhachHang.class, maKH);
	}
	public List<KhachHang> searchSDT(String key){
		try {
			TypedQuery<KhachHang> q= em.createQuery("select kh from KhachHang kh where kh.sdt like :kw OR kh.hoTen LIKE :kw", KhachHang.class);
			q.setParameter("kw","%"+ key + "%");
			return q.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
	public boolean insert(KhachHang kh) {
		try {
			em.getTransaction().begin();
			em.persist(kh);
			em.getTransaction().commit();
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}
	public boolean update(KhachHang kh) {
		try {
			em.getTransaction().begin();
			em.merge(kh);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}
	}
	public boolean delete(String maKH) {
		try {
			KhachHang kh= em.find(KhachHang.class, maKH);
			em.getTransaction().begin();
			em.remove(kh);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			return false;
			
		}
	}
	public boolean checkSdtTrung(String sdt) {
		   try {
		       TypedQuery<Long> q = em.createQuery(
		        "SELECT COUNT(kh) FROM KhachHang kh WHERE kh.sdt = :sdt", Long.class
		        );
		        q.setParameter("sdt", sdt);
		        Long count = q.getSingleResult();
		        return count > 0;
		   } catch (Exception e) {
		       e.printStackTrace();
		       return false;
		   }
	}
	public List<KhachHang> search(String key) {
	    EntityManager em = EMF.getEMF().createEntityManager();
	    try {
	        TypedQuery<KhachHang> q = em.createQuery(
	            "SELECT k FROM KhachHang k " +
	            "WHERE LOWER(k.maKH) LIKE :key " +
	            "OR LOWER(k.hoTen) LIKE :key " +
	            "OR LOWER(k.sdt) LIKE :key",
	            KhachHang.class
	        );
	        q.setParameter("key", "%" + key.toLowerCase() + "%");
	        return q.getResultList();
	    } finally {
	        em.close();
	    }
	}

}