CREATE TABLE tokens (
  id                 INT          NOT NULL AUTO_INCREMENT,
  token              VARCHAR(255) NOT NULL UNIQUE,
  poll_id           INT,
  updated_at         DATETIME,
  created_at         DATETIME,
  PRIMARY KEY (id)
)