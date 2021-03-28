# 모든 데이터 베이스 조회
SHOW DATABASES;

# 만약 존재한다면 t1 데이터 베이스 삭제
DROP DATABASE IF EXISTS t1;

# t1 데이터 베이스 만들기
CREATE DATABASE t1;

# t1 데이터 베이스 선택
USE t1;

# article 테이블 만들기 (id, title, body)
CREATE TABLE article(
id INT(5),
title CHAR(100),
`body` TEXT
);

# id = 2, title = '제목2', body = '내용2' 데이터 하나 추가
INSERT INTO article
SET id = 2,
title = '제목2',
`body` = '내용2';

# id = 3, title = '제목3', body = '내용3' 데이터 하나 추가
INSERT INTO article
SET id = 3,
title = '제목3',
`body` = '내용3';

# id = 1, title = '제목1', body = '내용1' 데이터 하나 추가
INSERT INTO article
SET id = 1,
title = '제목1',
`body` = '내용1';

# 모든 데이터 조회
SELECT *
FROM article;

# 모든 데이터 id로 오름차순 정렬 조회
SELECT *
FROM article
ORDER BY id ASC;

# 모든 데이터 id로 내림차순 정렬 조회
SELECT *
FROM article
ORDER BY id DESC;

# id = 3, title = '제목1', body = '내용1' 데이터 하나 추가
INSERT INTO article
SET id = 3,
title = '제목1',
`body` = '내용1';

# id = 3, title = '제목2', body = '내용2' 데이터 하나 추가
INSERT INTO article
SET id = 3,
title = '제목2',
`body` = '내용2';

# 모든 데이터 id, title 순으로 오름차순 정렬 조회
SELECT *
FROM article
ORDER BY id ASC, title ASC;

# 모든 데이터 id, 오름차순 title 내림차순 정렬 조회
SELECT *
FROM article
ORDER BY id ASC, title DESC;
