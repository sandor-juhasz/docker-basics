package hu.sjuhasz.contacts.persistence;

import java.util.List;

import hu.sjuhasz.contacts.domain.Contact;

public interface ContactDAO {

	Contact getContact(int id) throws DataException;

	List<Contact> getContacts() throws DataException;
	
	void addContact(Contact contact) throws DataException;
	
	void deleteContact(Contact contact) throws DataException;
	
	void updateContact(Contact contact) throws DataException;
	
}
