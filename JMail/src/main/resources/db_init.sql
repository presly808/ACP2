-- CREATE DATABASE jmail;
DROP SCHEMA IF EXISTS jmail;

CREATE SCHEMA jmail;

use jmail;

DROP TABLE IF EXISTS letters;
DROP TABLE IF EXISTS users;

CREATE TABLE users(
  user_id int NOT NULL UNIQUE AUTO_INCREMENT,
  login VARCHAR(255),
  pass VARCHAR(255),
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




