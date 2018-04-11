
DROP DATABASE IF EXISTS db;
CREATE DATABASE db;

DROP TABLE IF EXISTS db.user;
CREATE TABLE db.user (
  id       INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK', 
  username VARCHAR(255) NOT NULL UNIQUE
  COMMENT 'username',
  password VARCHAR(255) NOT NULL
  COMMENT 'password'
)
  COMMENT 'user table';


# SELECT count(*) FROM db.user;-- ���ݵ�������642 8632
SELECT * FROM db.user;


# ���ڸ�ʽ  2018.01.02  DECIMAL(8, 2)  ��ʾ��λС��
DROP TABLE IF EXISTS db.book;
CREATE TABLE db.book (
  id      INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'id PK',
  title   VARCHAR(255)  NOT NULL UNIQUE
  COMMENT 'title NN',
  price   DECIMAL(8, 2) NOT NULL
  COMMENT 'price NN',
  amount  INT           NOT NULL
  COMMENT 'amount NN',
  pubTime DATE          NOT NULL
  COMMENT 'publish time NN'
)
  COMMENT 'book table';

SELECT *
FROM db.book;


/*
author  VARCHAR(255)  NOT NULL
COMMENT 'author NN',
*/