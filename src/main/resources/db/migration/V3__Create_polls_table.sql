CREATE TABLE polls (
  id                 INT          NOT NULL AUTO_INCREMENT,
  title              VARCHAR(100) NOT NULL UNIQUE,
  description        TEXT NOT NULL,
  start_at           DATETIME NOT NULL,
  end_at             DATETIME NOT NULL,
  updated_at         DATETIME,
  created_at         DATETIME,
  PRIMARY KEY (id)
)