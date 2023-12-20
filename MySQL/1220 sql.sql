CREATE DATABASE tabledb;

CREATE TABLE `usertbl` (
 `userID` char(8) NOT NULL PRIMARY KEY,
 `name` VARCHAR(10) NOT NULL,
 `email` CHAR(30) UNIQUE,
 `birthYear` int Check (birthYear >= 1900 AND birthYear <= 2024),
 `addr` CHAR(2) NOT NULL DEFAULT '서울',
 `mobile1` CHAR(3) DEFAULT NULL,
 `mobile2` CHAR(8) DEFAULT NULL,
 `height` smallint DEFAULT NULL,
 `mDate` date DEFAULT null
 );
 
 -- 테이블 생성 후 수정으로 제약조건 
 ALTER TABLE userTBL
	ALTER COLUMN birthYear SET DEFAULT -1;
    
-- 뷰 생성하기
CREATE VIEW v_usertable
	AS SELECT userid, name, addr from usertbl;
    
select * from v_usertable;

-- INDEX (책 378~)
