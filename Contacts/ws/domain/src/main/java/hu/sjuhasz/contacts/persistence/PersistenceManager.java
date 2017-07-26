package hu.sjuhasz.contacts.persistence;

import java.util.ServiceLoader;

public class PersistenceManager {

	public static void init(String url, String username, String password) {
		adapter.init(url, username, password);
	}
	
	public static void close() {
		adapter.close();
	}
	
	public static ContactDAO getContactDAO() {
		return adapter.getContactDAO();
	}
	
	private static PersistenceAdapter adapter;
	
	static {
		ServiceLoader<PersistenceAdapter> adapterServiceLoader = ServiceLoader
				.load(PersistenceAdapter.class);
		for (PersistenceAdapter a : adapterServiceLoader) {
			adapter = a;
			break;
		}						
	}
		
}
