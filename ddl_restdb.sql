CREATE DATABASE IF NOT EXISTS restdb;
CREATE USER IF NOT EXISTS 'franz'@'localhost' identified by 'kafka';
GRANT ALL ON restdb.* TO 'franz'@'localhost';
FLUSH PRIVILEGES;
USE restdb;
DROP TABLE IF EXISTS message;
CREATE TABLE message (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    topic VARCHAR(50) NOT NULL,
    message TEXT NOT NULL
);