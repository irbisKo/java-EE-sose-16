CREATE TABLE user_poll_listings (
  id         INT NOT NULL AUTO_INCREMENT,
  user_id    INT NOT NULL,
  poll_id    INT NOT NULL,
  updated_at DATETIME,
  created_at DATETIME,
  PRIMARY KEY (id)
)