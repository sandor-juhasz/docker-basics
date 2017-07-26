package hu.sjuhasz.contacts.persistence.mariadb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table( name = "contact" )
public class Contact {
	
	private Integer id;
	
	private String name;
	
	private String email;

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public hu.sjuhasz.contacts.domain.Contact toDomainObject() {
		return new hu.sjuhasz.contacts.domain.Contact(id, name, email);
	}
	
	
}
