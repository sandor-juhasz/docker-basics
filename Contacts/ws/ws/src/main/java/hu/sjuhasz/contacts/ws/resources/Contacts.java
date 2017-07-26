package hu.sjuhasz.contacts.ws.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import hu.sjuhasz.contacts.domain.Contact;
import hu.sjuhasz.contacts.persistence.ContactDAO;
import hu.sjuhasz.contacts.persistence.DataException;
import hu.sjuhasz.contacts.persistence.PersistenceManager;

@Path("/contacts")
public class Contacts {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String contacts() {
    	ContactDAO contactDAO = PersistenceManager.getContactDAO();
    	StringBuilder sb = new StringBuilder();
    	try {
	    	for (Contact c : contactDAO.getContacts()) {
		    sb.append("{\n");
		    sb.append("id: "+c.getId()+"\n");
		    sb.append("name: "+c.getName()+"\n");
		    sb.append("email: "+c.getEmail()+"\n");
		    sb.append("}\n"); 
	    	}
    	} catch (DataException e) {
    		return "Error.";
    	}
        return sb.toString();
    }
}
