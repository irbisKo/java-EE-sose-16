ALTER TABLE users ADD COLUMN confirmed_at DATETIME AFTER salt;
ALTER TABLE users ADD COLUMN confirmation_sent_at DATETIME AFTER confirmed_at;