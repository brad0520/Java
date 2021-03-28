# 연습문제 5번

# 모든 데이터 베이스 조회
SHOW DATABASES;

# 만약 존재한다면 t1 데이터 베이스 삭제
DROP DATABASE IF EXISTS t1;

# t1 데이터 베이스 만들기
CREATE DATABASE t1;

# t1 데이터 베이스 선택
USE t1;

# article 테이블 만들기 (id, title, body)
CREATE TABLE article (
id INT(5),
title CHAR(50),
`body` TEXT
);

# id = 1, title = '제목1', body = '내용1' 데이터 하나 추가
INSERT INTO article
SET id = 1,
title = '제목1',
`body` = '내용1';

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

# 아래 부터는 수정과 삭제가 이루어진 다음 select * from article을 이용해 결과를 확인해주세요.
SELECT * 
FROM article;

# 모든 게시물의 제목을 aaa로, 내용을 bbb로 변경
UPDATE article
SET title ='aaa',
`body` = 'bbb';

SELECT * 
FROM article;

# 1번 게시물만 조회
SELECT * 
FROM article
WHERE id = 1;

# 1번 게시물의 제목을 제목1으로 변경
UPDATE article
SET title = '제목1'
WHERE id = 1;

SELECT * 
FROM article;

# 2번 게시물만 조회
SELECT * 
FROM article
WHERE id = 2;

# 2번 게시물의 내용을 내용2으로 변경
UPDATE article 
SET `body` = '내용2'
WHERE id = 2;

SELECT * 
FROM article;

# 3번 게시물만 조회
SELECT * 
FROM article
WHERE id = 3;

# 3번 게시물의 제목을 제목3, 내용을 내용3으로 변경
UPDATE article
SET title = '제목3',
`body` = '내용3'
WHERE id = 3;

SELECT * 
FROM article;

# 모든 게시물 데이터 삭제
DELETE FROM article;

SELECT * 
FROM article;

# id = 1, title = '제목1', body = '내용1' 데이터 하나 추가
INSERT INTO article
SET id = 1,
title = '제목1',
`body` = '내용1';

SELECT * 
FROM article;

# id = 2, title = '제목2', body = '내용2' 데이터 하나 추가
INSERT INTO article
SET id = 2,
title = '제목2',
`body` = '내용2';

SELECT * 
FROM article;

# id = 3, title = '제목3', body = '내용3' 데이터 하나 추가
INSERT INTO article
SET id = 3,
title = '제목3',
`body` = '내용3';

SELECT * 
FROM article;

# id가 1인 게시물 삭제
DELETE FROM article
WHERE id = 1;

SELECT * 
FROM article;

# 제목이 제목2인 게시물 삭제
DELETE FROM article
WHERE id = 2;

SELECT * 
FROM article;

# 내용이 내용3인 게시물 삭제
DELETE FROM article
WHERE id = 3;

SELECT * 
FROM article;
