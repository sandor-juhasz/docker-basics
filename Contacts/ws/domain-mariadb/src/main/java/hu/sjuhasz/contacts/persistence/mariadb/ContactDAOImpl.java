package hu.sjuhasz.contacts.persistence.mariadb;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import hu.sjuhasz.contacts.domain.Contact;
import hu.sjuhasz.contacts.persistence.ContactDAO;
import hu.sjuhasz.contacts.persistence.DataException;

/**
 * Contact DAO Implementation with MariaDB
 * @author developer
 *
 */
public class ContactDAOImpl implements ContactDAO {

	public Contact getContact(int id) throws DataException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}

	public List<Contact> getContacts() throws DataException {
		EntityManager em = null;
		try {
			em = EMFUtils.getEntityManager();
			TypedQuery<hu.sjuhasz.contacts.persistence.mariadb.Contact> q = em.createQuery("SELECT c FROM Contact c", hu.sjuhasz.contacts.persistence.mariadb.Contact.class);
			List<Contact> contacts = new ArrayList<>();
			for (hu.sjuhasz.contacts.persistence.mariadb.Contact c : q.getResultList()) {
				contacts.add(c.toDomainObject());
			}
			return contacts;
		} finally {
			if (em != null)
				em.close();
		}
	}
	
	public void addContact(Contact contact) throws DataException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	
	public void deleteContact(Contact contact) throws DataException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	
	public void updateContact(Contact contact) throws DataException {
		throw new UnsupportedOperationException("Not implemented yet.");
	}
	
}
