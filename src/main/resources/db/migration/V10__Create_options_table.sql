CREATE TABLE options (
  id          INT          NOT NULL AUTO_INCREMENT,
  item_id     INT          NOT NULL,
  name        VARCHAR(255) NOT NULL,
  vote_count  INT NOT NULL DEFAULT 0,
  description TEXT(5000)   NOT NULL,
  updated_at  DATETIME,
  created_at  DATETIME,
  PRIMARY KEY (id)
)