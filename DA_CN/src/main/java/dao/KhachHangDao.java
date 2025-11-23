package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.mysql.cj.conf.ConnectionUrl.Type;

import model.KhachHang;
import uti.EMF;

public class KhachHangDao {

	private EntityManager em;
	public KhachHangDao() {
		em=EMF.getEntityManagerFactory().createEntityManager();
	}
	
	//dang ky cho khach hang
	public boolean dangky(KhachHang kh) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(kh);
			tx.commit();
			return true;
		} catch (Exception e) {
			if(tx.isActive())
				tx.rollback();
			return false;
			// TODO: handle exception
		}finally {
			
		}
	}
	
	//khach hang dang nhap
	public KhachHang login(String sdt, String matkhau) {
		try {
			TypedQuery<KhachHang> query= em.createQuery("SELECT k FROM KhachHang k WHERE k.sdt = :sdt AND k.mk = :mk", KhachHang.class);
					query.setParameter("sdt", sdt);
					query.setParameter("mk", matkhau);
					List<KhachHang> result= query.getResultList();
					return result.isEmpty() ? null : result.get(0);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	
	// kiem khach hang theo sdt
	public KhachHang FindById(String sdt) {
		try {
		return em.createQuery("SELECT k FROM KhachHang k WHERE k.sDT = :sdt", KhachHang.class).setParameter("sdt", sdt).getSingleResult();
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
	}finally {
		
	}
	}
	//kt trung so dien thoai cua khach
	public boolean KT_SDT(String sdt) {
		try {
			long count=em.createQuery("SELECT COUNT(k) FROM KhachHang k WHERE k.sDT = :sdt", long.class).setParameter("sdt", sdt).getSingleResult();
			return count >0;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}finally {
			
		}
	}
	
}
