-- num(int) / id / pass / name / addr / phone / gender / age(int)
CREATE TABLE pri_member(
	num INT PRIMARY KEY auto_increment,
	id VARCHAR(30) UNIQUE NOT NULL,
	pass VARCHAR(30) NOT NULL,
	name VARCHAR(50),
	addr TEXT,
	phone VARCHAR(20),
	gender VARCHAR(10),
	age int(3)
);

-- 관리자 계정 추가 - id : admin , pass - admin , name - MASTER
INSERT INTO pri_member 
VALUES(null,'admin','admin','MASTER',
	   '부산광역시','01011111111','남성',30);
	   
SELECT * FROM pri_member;

commit;

-- 공지글 게시판
CREATE TABLE IF NOT EXISTS notice(
	notice_num INT PRIMARY KEY AUTO_INCREMENT,		-- 공지 글 번호
	notice_actegory VARCHAR(20) NOT NULL,			-- 공지 분류
	notice_author VARCHAR(50) NOT NULL,				-- 작성자
	notice_title VARCHAR(200) NOT NULL,				-- 제목
	notice_content TEXT NOT NULL,					-- 내용
	notice_date TIMESTAMP NOT NULL DEFAULT now()	-- 작성 시간
);

-- Q&A 게시판
CREATE TABLE IF NOT EXISTS qna(
	qna_num INT PRIMARY KEY AUTO_INCREMENT,		-- 글번호
	qna_name VARCHAR(20) NOT NULL,				-- 작성자
	qna_title VARCHAR(200) NOT NULL,			-- 글 제목
	qna_content TEXT NOT NULL,					-- 글 내용
	qna_writer_num INT NOT NULL,				-- 글 작성자 회원번호
	qna_readcount INT DEFAULT 0,				-- 조회수
	qna_date TIMESTAMP DEFAULT now()			-- 글 작성 시간
);
