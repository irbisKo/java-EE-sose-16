CREATE TABLE users (
  id                 INT          NOT NULL AUTO_INCREMENT,
  email              VARCHAR(100) NOT NULL,
  password_encrypted VARCHAR(100) NOT NULL,
  updated_at         DATETIME,
  created_at         DATETIME,
  PRIMARY KEY (id)
)