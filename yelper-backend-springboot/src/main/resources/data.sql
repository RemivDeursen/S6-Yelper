
INSERT INTO roles (id, name) VALUES (1, 'User');
INSERT INTO roles (id, name) VALUES (2, 'Moderator');
INSERT INTO roles (id, name) VALUES (3, 'Administrator');

-- Path: src\main\resources\data.sql
-- String firstName, String lastName, String email, String username, String password
INSERT INTO users (id, first_name, last_name, username, password, email)
VALUES (1, 'Firstname1', 'Lastname1', 'User1', 'password', 'user1@hotmail.com');
INSERT INTO users (id, first_name, last_name, username, password, email)
VALUES (2, 'Firstname2', 'Lastname2', 'User2', 'password', 'user2@hotmail.com');