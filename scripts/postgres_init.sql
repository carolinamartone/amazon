INSERT INTO role (id,name)
VALUES (1,'ROLE_ADMIN');
INSERT INTO role (id,name)
VALUES (2,'ROLE_CLIENT');
INSERT INTO user_roles(user_role_id,role_id,username)
VALUES (1,'ROLE_ADMIN','carolina');
INSERT INTO users (username,active,password)
VALUES('carolina',true,'carolina');
COPY articolo (category_id,immagine_url,name,prezzo,quantita) FROM '/Users/Carolina.Martone/workspace/Amazon/upload/AmazonArticoli.csv' DELIMITER ';' CSV;