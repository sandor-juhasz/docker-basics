CREATE USER apps IDENTIFIED BY 'apps';

GRANT CREATE, DROP, SELECT, INSERT, UPDATE, DELETE on contacts.* to apps@'%';
