DROP TABLE IF EXISTS userinfo;

CREATE TABLE userinfo (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  status BOOLEAN NOT NULL,
  role VARCHAR(250) DEFAULT NULL
);

INSERT INTO userinfo (username, password, status,role) VALUES
  ('vinod', 'vinod', TRUE,'ROLE_ADMIN'),
  ('admin', 'admin', TRUE,'ROLE_ADMIN'),
  ('amit', 'amit', TRUE,'ROLE_USER');