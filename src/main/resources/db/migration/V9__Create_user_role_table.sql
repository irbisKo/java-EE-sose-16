CREATE TABLE user_roles (
  id                 INT          NOT NULL AUTO_INCREMENT,
  user_id            INT NOT NULL,
  role_id            INT NOT NULL,
  updated_at         DATETIME,
  created_at         DATETIME,
  PRIMARY KEY (id)
)