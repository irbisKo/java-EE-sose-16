CREATE TABLE roles (
  id                 INT          NOT NULL AUTO_INCREMENT,
  name              VARCHAR(100) NOT NULL,
  updated_at         DATETIME,
  created_at         DATETIME,
  PRIMARY KEY (id)
)