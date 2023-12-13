-- SELECT 문
	-- SELECT 컬럼이름
	-- from 테이블이름
	-- where 조건 
    
use employees;
-- 테이블의 모든 컬럼 조회
SELECT 
    *
FROM
    titles;
-- 데이터 명 접근
SELECT 
    *
FROM
    employees.titles;
-- 한 컬럼만 선택하기
SELECT title from titles;
-- 여러 컬럼 선택하기(콤마로 구분)
select emp_no, title from title;

-- 데이터베이스 조회 순서
-- 모든 데이터베이스 조회하기
SHOW DATABASES;
use employees;
-- 데이터베이스 내 테이블 간단 이름보기
SHOW TABLES;
-- 데이터베이스 내 테이블 정보 조회하기
SHOW TABLE STATUS;
-- 테이블의 열(=컬럼 = 필드) 확인하기
DESCRIBE employees;
DESC employees;
-- 확인한 컬럼으로 select문 조회하기
SELECT emp_no, first_name, gender from employees;

-- 데이터베이스 생성 및 데이터 삽입

-- 기존 데이터베이스가 존재한다면 삭제하기
drop DATABASE if EXISTS sqldb;
-- 데이터베이스 생성
CREATE DATABASE sqldb;
use sqldb;		-- 데이터베이스 사용
-- 테이블 생성
-- 컬럼명		데이터 타입	제약조건, ...,
CREATE TABLE usertbl
( userID	CHAR(8)		not NULL	PRIMARY KEY, -- 사용자 아이디
  name		varchar(10)	not NULL,				 -- 이름
  birthYear	INT			NOT NULL,				 -- 생년
  addr		CHAR(2)		NOT NULL,				 -- 주소
  moblie1	CHAR(3),							 -- 국번 010
  moblie2	CHAR(8),							 -- 국번 외 전화번호
  height	SMALLINT,							 -- 키
  mDate		DATE								 -- 회원가입일
);
CREATE TABLE buytbl
(num		INT	AUTO_INCREMENT	NOT NULL	PRIMARY KEY,	-- 순번
userID		CHAR(8)				NOT NULL,					-- 회원ID
prodName	CHAR(4)				NOT NULL,					-- 상품평
groupName	CHAR(4),										-- 분류
price		Int					NOT NULL,					-- 가격
amount		SMALLINT			NOT NULL,					-- 수량
FOREIGN KEY	(userID) REFERENCES usertbl(userID)
);

-- 데이터 삽입 INSERT 문
-- 컬럼명 생략 시 전체 컬럼의 값
-- INSERT INTO 테이블명 (컬럼명1, 컬럼명2, ...)
-- VALUES (값1, 값2, ...)
desc usertbl;
INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO usertbl VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO usertbl VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO usertbl VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO usertbl VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200,  1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buytbl VALUES(NULL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buytbl VALUES(NULL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buytbl VALUES(NULL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);

SELECT * FROM usertbl;
SELECT * FROM buytbl;