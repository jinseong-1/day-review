-- 데이터베이스 선택
USE sqldb;

-- DDL 테이블 생성
create table testTbl(id int, userName char(3), age int);

-- DML - INSERT 데이터 삽입
INSERT INTO testTbl(id, userName,age) value(1, '홍길동', 30);
-- 생략한 열에는 NULL값이 들아간다.
INSERT INTO testTbl(id, userName) value(2, '홍길순');
-- 전체 컬럼 값을 순서대로 삽입할 경우 컬럼 생략 가능
INSERT INTO testTbl value(3, '홍길서',32);
-- 순서를 변경할 경우, 입력한 열의 순서에 맞게 값을 입력
INSERT INTO testTbl(age, id, userName) value(30, 1, '홍길동');

-- DQL : 데이터 조회
SELECT * FROM testTbl;

-- AUTO_INCREMENT 숫자 자동증가
create table testTbl2
	(id INT AUTO_INCREMENT	PRIMARY key, userName char(3), age int);
    
INSERT Into testTbl2 values (null,'홍길서',31);
INSERT Into testTbl2 values (null,'홍길동',32);
INSERT Into testTbl2 values (null,'홍길남',33);
INSERT Into testTbl2 values (null,'홍길북',34);

select * from testTbl2;
-- DDL 테이블의 자동증가번호 변경
ALTER TABLE testTbl2 AUTO_INCREMENT=100;

INSERT into testTbl2 values(null,'홍길순',35);

-- 자동증가 값을 변경하기(서버 변수 변경)
set @@auto_increment_increment=3;

INSERT into testTbl2 values(null,'홍길낄',36);
INSERT into testTbl2 values(null,'홍길갈',37);
INSERT into testTbl2 values(null,'홍길감',38);

SELECT * FROM testTbl2;

-- 증가값 복구
set @@auto_increment_increment=1;

-- 샘플 데이터 생성하기
SELECT * From testTbl3;
create table testTbl3 (id int, Fname varchar(50), Lname varchar(50));
-- INSERT Into ~SELECT 문
INSERT INTO testTbl3
	SELECT emp_no, first_name, last_name from employees.employees;

-- UPDATE : 데이터 수정하기
UPDATE testTbl3
	SET Lname = '없음'
    WHERE Fname = 'Kyoichi';
    
SELECT * From testTbl3 where fname = 'kyoichi';

use sqldb;
select * from buytbl;

-- where 조건절을 생략하게 될 경우, 전체 행의 값이 변경된다.(주의)
UPDATE buytbl
	set price = price * 1.5;
select * from buytbl;

-- DELETE : 삭제
SELECT * From testTbl3;

-- 해당 조건에 부합하는 경우 모두 삭제
DELETE FROM testTbl3 where fname = 'Georgi';

-- 상위 5건만 삭제하기
SELECT * from testTbl3 where fName = 'Bezalel';
DELETE FROM testTbl3 where fname = 'Bezalel' LIMIT 5;

-- autocommit 설정 확인 및 변경
-- 명령문이 실행될 때 자동으로 commit 수행 여부
SELECT @@autocommit; -- 1 : TRUE : 자동 커밋 설정 상태
Set @@autocommit := 0; -- 0: FALSE : 자동 커밋 설정 해제
set @@autocommit := true;
set @@autocommit := false;

select * from testTbl3;
UPDATE testTbl3 SET Fname = '없음';
select * from testTbl3;
-- TCL : 현재 세션에서 실행된 작업 이전 commit 시점으로 되될림
ROLLBACK;			
select * from testTbl3;
UPDATE testTbl3 SET Fname = '없음';
commit;		-- 현재 세션에서 실행된 작업을 적용

-- 커밋을 수행한 지점으로 롤백 : 그 이전으로 롤백되지 않음.
ROLLBACK;
select * from testTbl3;


-- 테이블 삭제하기
CREATE TABLE testTbl4 (SELECT * FROM employees.employees);
CREATE TABLE testTbl5 (SELECT * FROM employees.employees);
CREATE TABLE testTbl6 (SELECT * FROM employees.employees);

select * from testTbl4;

-- 모든 행을 삭제(데이터 구조는 남아있음 DML, commit 하지않았을때 롤백 가능)
DELETE from testTbl4;
ROLLBACK;

-- 모든 데이터를 삭제(데이터 구조는 남아있음)
TRUNCATE TABLE testTbl5;		-- DDL은 커밋을 포함, 롤백되지 않음.
SELECT * from testTbl5;
ROLLBACK;

-- 테이블 자체를 삭제(데이터 구조가 남아있지 않음)
SELECT * from testTbl6;
Drop TABLE testTbl6;			-- DDL : 커밋을 포함
ROLLBACK;

-- 오토 커밋 원상복구
SET @@autocommit = true;