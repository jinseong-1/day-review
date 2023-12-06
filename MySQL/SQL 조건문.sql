-- 특정한 조건의 데이터만 조회하기
-- where 절
-- SELECT 컬럼명(필드명) FROM 테이블명 WHERE 조건식;
use sqldb;

SELECT * FROM usertbl WHERE name = '김경호';
SELECT * FROM usertbl WHERE name = '이승기';
-- 주소가 서울인 사람 조회
SELECT * FROM usertbl WHERE addr = '서울';
-- 키가 175이상인 사람 조회
SELECT * FROM usertbl WHERE height >= 175;
-- 1970년 이후에 출생한 사람
SELECT * FROM usertbl WHERE birthYear >= 1970;

-- 조건을 2가지 이상 사용(관계 연산자)
-- and
SELECT * FROM usertbl 
WHERE height>=180 AND birthYear>=1975;
-- or
SELECT * FROM usertbl 
WHERE height>=180 OR birthYear>=1975;
-- BETWEEN ... AND
-- 연속적인 값(Continious)을 가진 숫자 범위
SELECT * FROM usertbl 
WHERE height>=180 and height<=185;
SELECT * FROM usertbl 
WHERE height BETWEEN 180 and 185;
-- IN() 이산적인 값(Discreate)을 가진 문자열 조회
SELECT * FROM usertbl 
WHERE addr='서울' or addr='전남' or addr='경남';
SELECT * FROM usertbl 
WHERE addr in ('서울', '전남', '경남');

-- LIKE : 문자열의 내용을 검색
-- 와일드카드 %(무엇이든 허용), _(한글자와 매칭)
SELECT * FROM usertbl WHERE name LIKE '김%';
SELECT * FROM usertbl WHERE name LIKE '_범수';

-- 서브쿼리(SubQuery) : 쿼리문 안에 쿼리문이 들어 있는 것
-- 김경호보다 키가 큰 사람을 질의하고 싶을 때
SELECT height FROM usertbl WHERE name = '김경호';
SELECT name, height FROM usertbl WHERE height > '177';

-- 단일행(single row) 서브쿼리
SELECT name, height FROM usertbl 
WHERE hegiht > (SELECT height FROM usertbl WHERE name = '김경호');

-- SELECT 컬럼명 FROM 테이블명 
-- WHERE 조건 연산자 (SELECT 컬럼명 FROM 테이블명 WHERE 조건문);

-- 다중 행(multi row) 서브쿼리
SELECT height FROM usertbl WHERE addr = '경남';		-- 2가지의 결과값
-- 행이 2개 이상이라 에러 발생
SELECT name, height FROM usertbl 
WHERE height > (SELECT height FROM usertbl WHERE addr = '경남');
-- ANY 구문을 사용하면 170보다 크거나, 173보다 크거나 => 170보다 큰 사람
SELECT name, height FROM usertbl 
WHERE height > ANY (SELECT height FROM usertbl WHERE addr = '경남');
-- ALL 구문을 사용하면 170보다 크고, 173보다 큰 사람 => 173보다 큰 사람
SELECT name, height FROM usertbl 
WHERE height > ALL (SELECT height FROM usertbl WHERE addr = '경남');

-- ORDER BY
-- 순서를 조절하는 구문, 쿼리 결과를 정렬
-- 기본값은 오름차순(ASC), 내림차순(DESC)

-- 가입일 기준 오름차순
SELECT * FROM usertbl ORDER BY mDate;		-- 기본값 : 오름차순
SELECT * FROM usertbl ORDER BY mDate ASC;	-- 위 아래 같은 문장
SELECT * FROM usertbl ORDER BY mDate DESC;	-- 내림차순

-- 2가지 이상 기준을 사용할 경우
SELECT * FROM usertbl ORDER BY addr ASC, height DESC;

-- 주의사항 : 데이터베이스의 개수가 많을 경우 성능을 떨어뜨릴 소지가 있음.

-- DISTINCT : 중복 제거하기
SELECT addr FROM usertbl ORDER BY addr;
SELECT DISTINCT addr FROM usertbl ORDER BY addr;

-- LIMIT : 출력개수를 제한하기
use employees;
SELECT * FROM employees ORDER BY hire_date ASC;
-- 입사일이 제일 오래된 5명만 조회하고 싶을때
SELECT * FROM employees ORDER BY hire_date ASC LIMIT 5;

-- LIMIT 시작인덱스, 개수
-- 6~10까지
SELECT * FROM employees ORDER BY hire_date ASC LIMIT 5, 5;

-- 10~5까지
SELECT * FROM employees ORDER BY hire_date ASC LIMIT 10, 5;

-- 'LIMIT 개수 OFFSET 시작위치' 형식으로 사용 가능
SELECT * FROM employees ORDER BY hire_date ASC LIMIT 5 offset 10;

-- 테이블 복사하기
-- CREATE TABLE 새로운테이블명(SELECT 복사할열 FROM 복사할 테이블)
use sqldb;
-- 전체 열 복제하기
CREATE TABLE buytbl2(SELECT * FROM buytbl);
SELECT * FROM buytbl2;
-- 테이블을 복사한 경우 PK, FK 등의 제약조건은 복사되지 않는다.
DESC buytbl;
DESC buytbl2;

-- 일부 컬럼만 복제하기
CREATE TABLE buytbl3(SELECT prodName FROM buytbl);
SELECT * FROM buytbl3;

-- GROUP BY : 그룹으로 묶어주는 역할, 집계함수와 같이 사용
SELECT userID, amount FROM buytbl ORDER BY userId;
SELECT userID, sum(amount) FROM buytbl GROUP BY userId;

-- 집계함수 sum(), min(), max(), avg(), count()
SELECT AVG(amount) from buytbl;
SELECT userID, avg(amount) FROM buytbl GROUP BY userId;

-- 가장 키가 큰 사람과 키 구하기
SELECT MAX(height) from usertbl;						-- 가장 큰 키 구하기
SELECT name, MAX(height) from usertbl GROUP BY name;
-- 조건절에 서브쿼리를 추가하여 최대값과 사람이름을 구하기
SELECT name, height from usertbl 
WHERE height = (SELECT MAX(height) from usertbl);
SELECT name, height from usertbl 
WHERE height = (SELECT Min(height) from usertbl);

-- COUNT 숫자 세기
SELECT * FROM usertbl;
-- 전체회원의 수 : 10
SELECT count(*) FROM usertbl;
-- 휴대폰 정보가 등록된 회원의 수
SELECT count(mobile) FROM usertbl;

-- HAVING : GROUP BY 와 함께 사용되는 조건절
-- GROUP BY로 나온 집계함수에 조건 필터링이 가능하다.
-- 사용자별 총구매액(가격*구매양) 구하기
SELECT userID, sum(price*amount) FROM buytbl GROUP BY userID;
SELECT userID, sum(price*amount) FROM buytbl 
GROUP BY userID
HAVING sum(price*amount) > 1000;

-- 집계함수 기준 정렬 ORDER BY 사용 가능
SELECT userID, sum(price*amount) FROM buytbl 
GROUP BY userID
HAVING sum(price*amount) > 1000
ORDER BY sum(price*amount) DESC;
