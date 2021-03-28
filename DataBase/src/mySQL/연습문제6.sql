# 제약조건 -> 데이터를 올바르게 정확하게 저장하기 위해서 (무결성)
# 키

# 기존에 t1 데이터베이스가 존재 한다면 삭제
DROP DATABASE IF EXISTS t1;

# 새 데이터베이스(`t1`) 생성
CREATE DATABASE t1;
USE t1;
# article 테이블 생성(칼럼은 id, title, body)
CREATE TABLE article(
id INT(5),
title CHAR(50),
`body` TEXT
);

SELECT * 
FROM article;

# id 없는 테스트 데이터 등록
INSERT INTO article
SET title ='제목1',
`body` = '내용1';

# 데이터 조회
SELECT * 
FROM article;

# id가 NULL인 데이터 생성이 가능하네?
# id 데이터는 꼭 필수 이기 때문에 NULL을 허용하지 않게 바꾼다.
# 테이블 생성시 컬럼 구조 정의 할 때 정할 수 있다. 

# 테이블 수정을 통해서 제약을 추가 및 삭제 할 수 있다.
ALTER TABLE article
MODIFY id INT(5) NOT NULL;

# 기존의 NULL값 때문에 경고가 뜬다.
# 기존의 NULL값이 0으로 바뀐다.
INSERT INTO article
SET title ='제목2',
`body` = '내용2';

# 테이블 구조 확인
DESC article;

# 테이블 데이터 삭제
DELETE FROM article;


# id 없는 테스트 데이터 등록
INSERT INTO article
SET title ='제목1',
`body` = '내용1';

# 데이터 조회
SELECT * 
FROM article;

# 키 등록
# 생각해 보니 모든 행(row)의 id 값은 유니크 해야한다.
# alter를 이용해 id 칼럼의 옵션에 null 허용하지 않음과 유니크 옵션 붙이기.
ALTER TABLE article
MODIFY id INT(5) NOT NULL UNIQUE;

# id 중복 제거
# 오류가 난다. 왜냐하면 기존의 데이터 중에서 중복되는 값이 있다.
UPDATE article 
SET id = 1
LIMIT 1;

UPDATE article 
SET id = 2
WHERE id = 0;

# alter를 이용해 id 칼럼의 옵션에 null 허용하지 않음과 유니크 옵션 붙이기.
ALTER TABLE article
MODIFY id INT(5) NOT NULL UNIQUE;

# 데이터 조회
SELECT * 
FROM article;

# 테이블 구조 확인
DESC article;

# id 없는 테스트 데이터 2개 등록
INSERT INTO article
SET title ='제목4',
`body` = '내용4';

# 자동 증가 제약 (AUTO_INCREMENT)
ALTER TABLE article
MODIFY id INT(5) NOT NULL UNIQUE AUTO_INCREMENT;

# 자동 증가 제약 실행시 오류를 해결하기 위한 id 시작값이 1이어야 함
DELETE FROM article;

# id 없는 테스트 데이터 2개 등록
INSERT INTO article
SET title ='제목1',
`body` = '내용1';

# 데이터 조회
SELECT * 
FROM article;

# 테이블 생성시 주키 등록

# 기존에 t1 데이터베이스가 존재 한다면 삭제
DROP DATABASE IF EXISTS t1;

# 새 데이터베이스(`t1`) 생성
CREATE DATABASE t1;
USE t1;
# article 테이블 생성(칼럼은 id, title, body)
CREATE TABLE article(
id INT(5) PRIMARY KEY AUTO_INCREMENT,
title CHAR(50) NOT NULL,
`body` TEXT NOT NULL
);

# 테이블 구조 확인
DESC article;
