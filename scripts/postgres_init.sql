INSERT INTO role (id,name)
VALUES (1,'ROLE_ADMIN');
INSERT INTO role (id,name)
VALUES (2,'ROLE_CLIENT');
INSERT INTO user_roles(user_role_id,role,username)
VALUES (1,'ROLE_ADMIN','carolina');
INSERT INTO user_roles(user_role_id,role)
VALUES (2,'ROLE_CLIENT');
INSERT INTO users (username,active,password,user_role_id)
VALUES('carolina',true,'carolina',1);
