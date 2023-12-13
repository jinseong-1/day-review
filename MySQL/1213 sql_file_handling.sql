-- 영화 데이터베이스 만들기
CREATE DATABASE moviedb;

use moviedb;
CREATE TABLE movietbl
	(movie_id		INT,
    movie_title		varchar(30),
    movie_director	varchar(20),
    movie_star		varchar(20),
    movie_script	longtext,
    movie_film		longblob
    ) DEFAULT CHARSET=utf8mb4;

-- 영화 데이터 삽입 : longtext, longblob 이 삽입되지 않음
INSERT INTO movietbl VALUEs
(1, '쉰들러리스트','스필버그','리암 리슨',
load_file('/var/lib/mysql-files/Schindler.txt'),
load_file('/var/lib/mysql-files/Schindler.mp4')
);
INSERT INTO movietbl VALUEs
(2, '쇼생크탈출','프랭크 다라본트','팀 로빈스',
load_file('/var/lib/mysql-files/Shawshank.txt'),
load_file('/var/lib/mysql-files/Shawshank.mp4')
);
INSERT INTO movietbl VALUEs
(3, '라스트모히칸','마이클 만','다니엘',
load_file('/var/lib/mysql-files/Mohican.txt'),
load_file('/var/lib/mysql-files/Mohican.mp4')
);
select * from movietbl;

-- 파일 내보내기
SELECT movie_script from movietbl where movie_id = 2
	INTO OUTFILE '/var/lib/mysql-files/out.txt'
    LINES TERMINATED BY '\\n';
    
SELECT movie_film from movietbl where movie_id = 3
	INTO OUTFILE '/var/lib/mysql-files/out.mp4';

-- 시스템 변수 확인하기
show variables;
select @@max_allowed_packet;		-- 최대 허용 패킷 크기
select @@secure_file_priv;			-- 허용된 경로 위치. 현재 리눅스환경에 기반을 두기에 리눅스가 나옴