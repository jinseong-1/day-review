-- 수학 내장함수
-- ABS(숫자) : 절대값
SELECT abs(-30);

-- CEILING(숫자) : 올림
SELECT ceiling(4.1);
-- FLOOR(숫자) : 내림
SELECT floor(4.3);
-- ROUND(숫자) : 반올림
SELECT round(4.3); SELECT round(4.7);

-- CONV(숫자, 원래진수, 변환진수) : 진수변환
SELECT conv('FE',16,10) as practice; -- 16진수를 10진수로
SELECT conv('FE',16,2) as practice; -- 16진수를 2진수로
SELECT conv('111111110',2,8) as practice; -- 2진수를 8진수로

-- PI() : 원주율
SELECT PI();

-- MOD(숫자, 나눌 수) : 나머지 구하기
SELECT mod(157, 10), 157 % 10, 157 mod 10;

-- POW(숫자1, 제곱) : 제곱수 구하기
SELECT pow(2, 20); -- 2의 20제곱
-- SQRT(숫자) : 제곱근 구하기
SELECT sqrt(64); 	-- 루트64

-- RAND() : 랜덤한 숫자 구하기 0<n<1의 실수
SELECT rand(),rand()*6, floor(rand()*6)+1;

-- 날짜 및 시간 함수


-- ADDDATE(날짜, 차이) : 더한 날짜 구하기
SELECT adddate('2023-12-20',INTERVAL 31 DAY) as practice;
SELECT adddate('2023-12-20',INTERVAL 2 MONTH) as practice;
-- SUBDATE(날짜, 차이) : 뺀 날짜 구하기
SELECT SUBDATE('2023-12-20',INTERVAL 31 DAY) as practice;
SELECT SUBDATE('2023-12-20',INTERVAL 2 MONTH) as practice;

-- ADDTIME(날짜/시간, 시간) : 더한 시간 구하기
SELECT addtime('2023-12-20 23:59:59','1:1:1');
SELECT subtime('2023-12-20 23:59:59','1:1:1');
SELECT addtime(now(),'5:15:30');
SELECT subtime(now(),'5:15:30');

-- now() : 현재 시간 구하기
SELECT now(), localtime(), localtimestamp(); 	-- 동일한 현재 날짜/시각 구하기
SELECT curdate(),current_date(),current_date;	-- 동일한 현재 날짜 구하기
SELECT curtime(),current_time(),current_time;	-- 동일한 현재 시간 구하기

-- 날짜에서 연, 월, 일, 시 구하기
SELECT YEAR(now()),month(now()),day(now()),hour(now());
-- 분, 초, 마이크로
SELECT minute(now()), second(now()), microsecond(current_timestamp());

-- 날짜, 시간 추출하기
SELECT date(now()), time(now());

-- DATEDIFF(날짜1, 날짜2) : 날짜 차이구하기
SELECT datediff('2018-05-15',now());
-- TIMEDIFF(시간1, 시간2) : 시간 차이구하기
SELECT timediff('16:30:00',curtime());

-- DAYOFWEEK(날짜) : 요일구하기 (1 : 일요일 ~ 7 : 토요일) 반환
SELECT dayofweek(now());

-- LAST_DAY(날짜) : 마지막 날 구하기
SELECT last_Day('2024-02-01');

-- MAKETIME(시, 분, 초) : 시간형식 만들기
SELECT maketime(16,30,00);

-- QUARTER(날짜) : 분기 구하기
SELECT quarter(now());