-- admin@me.com / admin
-- staff@me.com / staff

INSERT INTO USERS (username, password, name, role) 
VALUES 
 	('admin@me.com', '$2a$10$e0NbodPYZd1oGJxkialws.VOAvB1.SC5idmwyb9cox7sV/q/MrR9O', 'administrator', 'ROLE_ADMIN'), 
 	('staff@me.com', '$2a$10$IafWKN8.bG1NNoBjWlbIUOuqV/cee9Pw.UAaYHK7WPe2QHaxpjG2O', 'manager', 'ROLE_STAFF');
	