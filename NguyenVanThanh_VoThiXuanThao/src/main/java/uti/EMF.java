package uti;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private static EntityManagerFactory emf=null;
	public static EntityManagerFactory getEMF() {
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory("thao");
		}
		return emf;
	}

}
