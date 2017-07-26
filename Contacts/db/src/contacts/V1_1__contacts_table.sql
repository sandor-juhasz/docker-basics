/*
 * Creates the base schema for the Contacts database.
 * Populates the base schema with default values.
 */

CREATE TABLE contact (
   id    INTEGER AUTO_INCREMENT PRIMARY KEY,
   name  VARCHAR(200),
   email VARCHAR(200)
);


INSERT INTO contact(name, email)  values ('John Doe', 'john.doe@acme.com');
INSERT INTO contact(name, email)  values ('Stephen Brown', 'sbrown@acme.com');
