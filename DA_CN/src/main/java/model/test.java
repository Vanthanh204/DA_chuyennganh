package model;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("thao");
		System.out.print("OK");
	}

}
