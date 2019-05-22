CREATE DATABASE IF NOT EXISTS `chatter_db`;

USE chatter_db;

CREATE TABLE IF NOT EXISTS users(
    username VARCHAR(30) PRIMARY KEY ,
    salt_value VARCHAR(10) NOT NULL ,
    password VARCHAR(50) NOT NULL ,
    usermail VARCHAR(40) NOT NULL UNIQUE ,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    userAuth VARCHAR(20) NOT NULL DEFAULT 'ROLE_USER'
);

INSERT IGNORE INTO users VALUES ('admin', SUBSTRING(RAND(), 1, 7), SHA1(CONCAT(salt_value, 'brainpower')), 'test@test.com', TRUE, 'ROLE_ADMIN');

CREATE TABLE IF NOT EXISTS articles(
    articleid INT(4) unsigned PRIMARY KEY auto_increment ,
    author VARCHAR(30) NOT NULL ,
    title VARCHAR(100) NOT NULL UNIQUE ,
    content mediumtext ,
    created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ,
    open BOOLEAN NOT NULL DEFAULT TRUE ,
    FOREIGN KEY (author) REFERENCES users(username)
);

INSERT IGNORE INTO articles(author, title, content, open) VALUES ('admin', 'test', 'lorem blah blah blah.', FALSE);