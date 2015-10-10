CREATE TABLE participant_list (
  id         INT          NOT NULL AUTO_INCREMENT,
  user_id    INT          NOT NULL,
  name       VARCHAR(100) NOT NULL,
  updated_at DATETIME,
  created_at DATETIME,
  PRIMARY KEY (id)
)