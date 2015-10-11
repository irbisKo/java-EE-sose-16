CREATE TABLE participants (
  id                 INT          NOT NULL AUTO_INCREMENT,
  email              VARCHAR(100) NOT NULL UNIQUE,
  created_at         DATETIME,
  updated_at         DATETIME,
  PRIMARY KEY (id)
)