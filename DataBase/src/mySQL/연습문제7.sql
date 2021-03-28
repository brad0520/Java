# 나머지 모든 컬럼에 not null 제약 걸기

# 기존에 t1 데이터베이스가 존재 한다면 삭제
DROP DATABASE IF EXISTS t1;

# 새 데이터베이스(`t1`) 생성
CREATE DATABASE t1;
USE t1;

# article 테이블 생성(칼럼은 id, title, body)
CREATE TABLE article(
id INT(5)  UNSIGNED PRIMARY KEY AUTO_INCREMENT,
title CHAR(50) NOT NULL,
`body` TEXT NOT NULL
);

SELECT * 
FROM article;

DESC article;

# id에 unsigned 제약 걸기

# 작성자(writer) 칼럼을 title 칼럼 다음에 추가.
ALTER TABLE article 
ADD COLUMN writer CHAR(20) NOT NULL
AFTER title;

# 작성자(writer) 칼럼의 이름을 nickname 으로 변경.
ALTER TABLE article
CHANGE COLUMN writer nickname CHAR(20);

# nickname 칼럼의 위치를 body 밑으로 보내주세요.
ALTER TABLE article 
MODIFY nickname CHAR(20) NOT NULL AFTER `body`;

# hit 조회수 칼럼 추가.
ALTER TABLE article 
ADD hit INT(10) NOT NULL;

# 테스트 데이터 추가

INSERT INTO article
SET title = '제목1',
`body` = '내용1',
nickname = '유저1',
hit = 20;

INSERT INTO article
SET title = '제목2',
`body` = '내용2',
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
hit = 100;

# 조회수 가장 많은 게시물 3개 만 보여주세요., 힌트 : ORDER 
SELECT * 
FROM article
ORDER BY hit DESC
LIMIT 3;

# 작성자명이 '1'을 포함하는 게시물만 보여주세요., 힌트 : LIKE
SELECT * 
FROM article
WHERE nickname LIKE '%1%';

# 조회수가 10 이상 55 이하 인것만 보여주세요., 힌트 : AND
SELECT * 
FROM article
WHERE hit >= 10 AND hit <=55;

# 작성자가 '유저1'이 아니고 조회수가 50 이하인 것만 보여주세요., 힌트 : !=
SELECT * 
FROM article
WHERE nickname != '유저1' AND hit <= 50;

# 작성자가 '유저1' 이거나 조회수가 55 이상인 게시물을 보여주세요. 힌트 : OR
SELECT * 
FROM article
WHERE nickname = '유저1' OR hit >= 55;
