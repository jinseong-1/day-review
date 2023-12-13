-- 변수 사용하기
-- SET @변수이름 = 변수의 값; 변수 선언	변수 선언
-- SELECT @변수 이름					변수 확인

SET @myVar1 = 10;
SET @myVar2 = 5;
SET @myVar3 = 3.14;
SET @myVar4 = '이름->';

SELECT @myVar1;
SELECT @myVar2 + @myVar2;

use sqldb;
SELECT @myVar4, name from usertbl;

select concat(@myVar4, '안녕하세요');

-- 데이터 타입 변환 함수
use sqldb;

-- CAST, CONVERT
-- 평균 구매 개수
SELECT avg(amount) as 평귱구매개수 from buytbl;

-- 정수로 타입 변한
-- cast(표현식 AS 데이터타입)
-- conver(표현식, 데이터타입)
SELECT cast(avg(amount) as SIGNED INTEGER) as 평균구매개수 from buytbl;
SELECT convert(avg(amount), SIGNED INTEGER) as 평균구매개수 from buytbl;

SELECT cast('2023-12-13' as DATE);
SELECT cast('2023.12.13' as DATE);
SELECT cast('2023@12@13' as DATE);
SELECT cast('2023$12$13' as DATE);

-- 숫자 데이터를 문자 데이터로 변환하여 연결한 예시
-- 명시적인 타입 변환
desc buytbl;
SELECT concat(
			cast(price as char(10)), 
            "*",
            cast(amount as char(10)),
            "="
		) as '단가*수량',
	price * amount from buytbl;

-- 암시적인 타입 변환(주의)
SELECT '100'+'200';			-- 정수로 암시적 형변환되어 연산
select concat('100','200');	-- 문자열 연결
SELECT concat(100, '200');	-- 정수가 문자열로 암시적 형변환되어 연결
SELECT 1 > '2mega';			-- 문자열이 정수 2로 변환되어 비교
SELECT 3 > '2mega';			-- 문자열이 정수 2로 변환되어 비교
SELECT 0 = 'mega';			-- 문자열은 비교시 0으로 변환됨. 1 즉, true 값이 출력됨

-- 내장함수
-- 제어 흐름 함수
-- if(수식, 참일때, 거짓일때)
SELECT if(100>200,'참','거짓');
SELECT if(100<200,'참','거짓');

-- ifnull(수식1, 수식2) : 수식1이 null이 아니면 수식1, null이면 수식2를 리턴.
SELECT ifnull(null, "null입니다");
SELECT ifnull(100, "null입니다");

-- nullif(수식1, 수식2) : 두 수식이 같으면 null, 다르면 수식1을 리턴
SELECT nullif(100,100);
SELECT nullif(100,101);

-- CASE 문 ~ WHEN ~ THEN
SELECT case 1
	WHEN 1	then '일'
    WHEN 10	then '십'
    ELSE '모르는 수'
end as "case";
