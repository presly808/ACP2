-- CREATE DATABASE jmail;

DROP TABLE letters IF EXISTS;
DROP TABLE users IF EXISTS;

CREATE TABLE users(
  user_id int NOT NULL UNIQUE AUTO_INCREMENT,
  login VARCHAR(20),
  pass VARCHAR(20),
  PRIMARY KEY (user_id)
);

CREATE TABLE letters(
  letter_id int NOT NULL UNIQUE AUTO_INCREMENT,
  title VARCHAR(100),
  body VARCHAR(255),
  to_user INT NOT NULL,
  from_user INT NOT NULL,
  send_date DATETIME,
  PRIMARY KEY (letter_id),
  FOREIGN KEY (to_user) REFERENCES users(user_id),
  FOREIGN KEY (from_user) REFERENCES users(user_id)
);

