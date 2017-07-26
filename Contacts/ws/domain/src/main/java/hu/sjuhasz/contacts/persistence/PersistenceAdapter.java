package hu.sjuhasz.contacts.persistence;

public interface PersistenceAdapter {

	void init(String url, String username, String password);
	
	void close();
	
	ContactDAO getContactDAO();
	
}
