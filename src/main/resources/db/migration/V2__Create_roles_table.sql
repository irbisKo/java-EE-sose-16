CREATE TABLE roles (
  id         INT          NOT NULL AUTO_INCREMENT,
  role_name       VARCHAR(100) NOT NULL,
  updated_at DATETIME,
  created_at DATETIME,
  PRIMARY KEY (id)
)