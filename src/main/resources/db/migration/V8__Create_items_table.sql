CREATE TABLE items (
  id          INT          NOT NULL AUTO_INCREMENT,
  poll_id     INT          NOT NULL,
  type        VARCHAR(255) NOT NULL,
  title       VARCHAR(255) NOT NULL,
  description TEXT(5000)   NOT NULL,
  updated_at  DATETIME,
  created_at  DATETIME,
  PRIMARY KEY (id)
)