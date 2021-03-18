DROP DATABASE IF EXISTS testdb;

# 새 데이터베이스(`testdb`) 생성
CREATE DATABASE testdb;

USE testdb;

# article 테이블 생성(칼럼은 id, title, body)
CREATE TABLE article(
id INT(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
title CHAR(100)NOT NULL,
`body` TEXT NOT NULL,
nickname CHAR(50) NOT NULL,
hit INT(5) NOT NULL
);

# 테스트 데이터 추가

INSERT INTO article
SET title = '제목1',
`body` = '내용1',
nickname = '유저1',
hit = 20;

INSERT INTO article
SET title = '제목2',
`body`= '내용2',
nickname = '유저2',
hit = 30;

INSERT INTO article
SET title = '제목3',
`body` = '내용3',
nickname = '유저3',
hit = 10;

# 데이터 추가
INSERT INTO article
SET title = '제목4',
`body` = '내용4',
nickname = '유저4',
hit = 55;

# 데이터 추가
INSERT INTO article
SET title = '제목5',
`body` = '내용5',
nickname = '유저5',
hit = 10;

# 데이터 추가
INSERT INTO article
SET title = '제목6',
`body` = '내용6',
nickname = '유저6',
hit = 90;

SELECT *
FROM article;

