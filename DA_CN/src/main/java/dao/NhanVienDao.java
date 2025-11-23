package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.mysql.cj.conf.ConnectionUrl.Type;

import model.NhanVien;
import uti.EMF;

public class NhanVienDao {
	private EntityManager em;
	public NhanVienDao(){
		em= EMF.getEntityManagerFactory().createEntityManager();
	}
	public NhanVien login(String maNV, String matkhau) {
		try {
			TypedQuery<NhanVien> q=  em.createQuery("SELECT nv FROM NhanVien nv WHERE nv.sdt = :ma AND nv.mk = :mk",
					NhanVien.class);
					q.setParameter("ma", maNV);
					q.setParameter("mk", matkhau);
					List<NhanVien> list= q.getResultList();
			return list.isEmpty() ? null : list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	//them nhan vien
	public boolean insert(NhanVien nv) {
		EntityTransaction tx= em.getTransaction();
		try {
			tx.begin();
			em.persist(nv);
			tx.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			if (tx.isActive())
				tx.rollback();
			return false;
		}
	}
	//tim nhan vien theo id
	public NhanVien FindById(String maNV) {
		try {
		return em.find(NhanVien.class, maNV);
	}finally {
		
	}
	}
	//kt trung so dien thoai
	public boolean KT_SDT(String sdt) {
		try {
			long count = em.createQuery("SELECT COUNT(nv) FROM NhanVien nv WHERE nv.sDT = :sdt", Long.class)
					.setParameter("sdt", sdt).getSingleResult();
			return count>0;
		}finally {
			
		}
	}
}
