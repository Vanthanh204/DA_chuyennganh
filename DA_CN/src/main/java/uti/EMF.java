package uti;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static final EntityManagerFactory emf;
	static {
		try {
			emf = Persistence.createEntityManagerFactory("thao");
		} catch (Throwable e) {
			// TODO: handle exception
			System.err.print("khoi tao that bai" + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}
	public static void close() {
		emf.close();
	}
}
