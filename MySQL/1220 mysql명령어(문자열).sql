-- 문자열 함수

-- ASCII : 아스키 코드 리턴
SELECT ASCII('A');
-- char : 아스키 코드를 문자열로 리턴
SELECT char(65);

-- LENGTH : 문자열의 길이
SELECT length('ABC'); -- 3
SELECT length('가나다'); -- 9 : UTF-8 인코딩 한글은 글자당 3BYTE로 인식
SELECT char_length('가나다'); -- 3 : 문자열 글자 길이 갯수만큼
SELECT bit_length('가나다'); -- 9 BYTE * 8 BIT : 72비트 수만큼

-- CONCAT(문자열1, 문자열2) : 문자열 이어주기
SELECT concat('가나다','라마바');
-- CONNCAT_WS(구분자, 문자열1, 문자열2) : 구분자로 문자열 이어주기
SELECT concat_ws('+','가나다','라마바','아자차');

-- 문자열 찾기
-- ELT(위치, 문자열1, 문자열2...) : 해당 위치의 문자열 반환
SELECT elt(3,'하나','둘','셋');
-- FIELD(찾을 문자열, 문자열1, 문자열2...) : 문자열의 위치를 반환
SELECT field('셋','하나','둘','셋');
-- find_in_set(찾을 문자열, 문자열목록) : 문자열 목록에서 위치를 반환
SELECT find_in_set('하나','하나,둘,셋');
-- INSTR(기분 문자열, 구분 문자열) : 기준 문자열에서 부분문자열의 위치를 반환
SELECT instr('하나둘셋','셋');
-- LOCATE(구분 문자열, 기분 문자열) : 기준 문자열에서 부분문자열의 위치를 반환
SELECT locate('셋','하나둘셋');

-- FORMAT(숫자, 소숫점 자리수) : 천단위로 끊어주기 + 소수점 자리수
SELECT format(1234567.1234567,2);

-- LEFT(문자열, 길이) : 왼쪽에서부터 문자열 길이만큼 반환
-- RIGHT(문자열, 길이) : 오른쪽에서부터 문자열 길이만큼 반환
SELECT left('가나다라마바사',3);
SELECT right('가나다라마바사',3);

-- UPPER(문자열) : 대문자로 변경
-- LOWER(문자열) : 소문자로 변경
SELECT upper('Hello, World!');
SELECT lower('Hello, World!');

-- 문자열 채우기
-- LPAD(문자열, 길이, 채울문자열);
SELECT lpad("12월",3,"0");
SELECT rpad("홍길동",7,"*");

-- 공백 제거하기
-- LTRIM(문자열)
SELECT ltrim( "         방탄소년단 bts" );
SELECT rtrim( "         방탄소년단 bts"               );

-- REPAET(문자열, 반복횟수) : 문자열 반복하기
SELECT repeat("가자!!!",10);

-- REPLACE(문자열, 변경할 문자열, 바꿀 문자열) : 문자열 변경하기
SELECT replace("이것이 MySQl","이것이","This is") as practice;

-- REVERSE(문자열) : 문자열 뒤집기
SELECT reverse("BANANA") as practice;

-- SPACE(공백길이) : 공백길이 리턴
SELECT CONCAT("방탄소년단",SPACE(14),"BTS") as practice;

-- ** SUBSTRING(문자열, 시작위치, 길이) : 시작위치부터 길이만큼 문자 반환 **
SELECT substr("Hello World!!",7,5) as practice; -- substr 과 substring 은 동일함수
SELECT substring("Hello World!!",-2,5) as practice; -- 음수 시작위치는 뒤에서부터 검색

