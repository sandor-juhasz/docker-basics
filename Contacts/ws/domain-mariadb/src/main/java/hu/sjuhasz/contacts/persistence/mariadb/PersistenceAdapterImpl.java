package hu.sjuhasz.contacts.persistence.mariadb;

import hu.sjuhasz.contacts.persistence.ContactDAO;
import hu.sjuhasz.contacts.persistence.PersistenceAdapter;

public class PersistenceAdapterImpl implements PersistenceAdapter {

	@Override
	public void init(String url, String username, String password) {
		EMFUtils.init(url, username, password);
	}

	@Override
	public void close() {
		EMFUtils.close();
	}

	@Override
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl();
	}

}
