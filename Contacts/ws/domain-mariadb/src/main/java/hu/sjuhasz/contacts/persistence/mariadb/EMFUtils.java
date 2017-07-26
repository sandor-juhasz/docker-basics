package hu.sjuhasz.contacts.persistence.mariadb;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMFUtils {

	private static EntityManagerFactory emf;
	
	public static void init(String url, String username, String password) {
		Map<String, String> properties = new HashMap<>();
		properties.put("javax.persistence.jdbc.driver", "org.mariadb.jdbc.Driver");
		properties.put("javax.persistence.jdbc.url", url);
		properties.put("javax.persistence.jdbc.user", username);
		properties.put("javax.persistence.jdbc.password", password);
		
		emf = Persistence.createEntityManagerFactory("hu.sjuhasz.contacts", properties);		
	}
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public static void close() {
		emf.close();
	}
}
