DROP DATABASE IF EXISTS BoardDB;

# 새 데이터베이스(`BoardDB`) 생성
CREATE DATABASE BoardDB;

USE BoardDB;

# article 테이블 생성(칼럼은 id, title, body)
CREATE TABLE article(
id INT(5) PRIMARY KEY NOT NULL AUTO_INCREMENT,
title CHAR(100)NOT NULL,
`body` TEXT NOT NULL,
writer CHAR(100) NOT NULL,
regDate CHAR(50) NOT NULL,
hit INT(5) NOT NULL
);

# 테스트 데이터 추가
INSERT INTO article
SET title = '제목1',
`body` = '내용1',
writer = '작성자1',
regDate = '2021-03-17',
hit = 50;

INSERT INTO article
SET title = '제목2',
`body` = '내용2',
writer = '작성자2',
regDate = '2021-03-18',
hit = 40;

INSERT INTO article
SET title = '제목3',
`body` = '내용3',
writer = '작성자3',
regDate = '2021-03-19',
hit = 60;

INSERT INTO article
SET title = '제목4',
`body` = '내용4',
writer = '작성자4',
regDate = '2021-03-20',
hit = 20;

INSERT INTO article
SET title = '제목5',
`body` = '내용5',
writer = '작성자5',
regDate = '2021-03-21',
hit = 70;

SELECT *
FROM article;

