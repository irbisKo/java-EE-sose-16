CREATE TABLE participants (
  id                 INT          NOT NULL AUTO_INCREMENT,
  email              VARCHAR(100) NOT NULL UNIQUE,
  PRIMARY KEY (id)
)