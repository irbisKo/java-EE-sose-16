CREATE TABLE users (
  id                 INT          NOT NULL,
  email              VARCHAR(100) NOT NULL,
  password_encrypted VARCHAR(100) NOT NULL,
  PRIMARY KEY (id)
)