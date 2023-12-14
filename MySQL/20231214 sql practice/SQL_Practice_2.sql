use cloud_digital;

-- 51. 사원들의 이름, 직무를 첫 자만 대문자로 검색하라
select concat(upper(substr(ename, 1,1)),lower(substr(ename,2))),
		concat(upper(substr(job, 1,1)),lower(substr(job,2)))
        from emp;

-- 52. 사원들의 이름, 직무를 연결하여 검색하라


-- 53. 사원들의 이름과 이름의 첫 2자를 검색하라
select ename,  substr(ename, 1, 2) from emp;

-- 54. 사원들의 이름, 직무 그리고 직무의 2번째부터 3자리를 검색하라
select ename, job , substr(job,2,3) from emp;

-- 55. 사원들의 이름과 이름의 길이를 검색하라
select ename, length(ename) from emp;

-- 56. 사원들의 직무와 직무의 자리수를 검색하라
select job, length(job) from emp;

-- 57. 사원들의 이름에 'A'가 몇 번째 있는지 검색하라
select ename, locate('A', ename) from emp;
select ename, instr(ename,'A') from emp;

-- 58. 사원들의 직무에 'A'가 몇 번째 있는지 검색하라
select job, locate('A',job) from emp;

-- 59. 사원의 이름을 15자리로 하고, 뒤에 '&'를 채워 검색하라
select ename, rpad(ename,15,'&') from emp;

-- 60. 사원의 직무를 20자리로 하고, 앞에 '%'를 채워 검색하라
select job, lpad(job, 20, '%') from emp;

-- 61. 사원의 사원번호, 이름, 급여를 검색하라(급여는 두번째 자리에서 반올림함)
select empno, ename, round(sal, -2) from emp;

-- 62. 사원의 사원번호, 이름, 급여를 검색하라(급여는 두번째 자리까지만 표시함)
select empno, ename, truncate(sal, -2) from emp;

-- 63. 사원번호와 급여를 100으로 나눈 나머지를 검색하라
select mod(empno, 100), mod(sal, 100) from emp;

-- 64. 사원번호, 이름과 입사일자, 입사일자 100일 후의 일자를 구하라
select empno, ename, adddate(hiredate,interval 100 day) from emp;

-- 65. 사원번호, 이름, 입사일자 그리고 근무 일자를 계산하여 구하라
select empno, ename, hiredate, datediff(now(), hiredate) from emp;

-- 66. 사원들의 입사일자에 3달째 되는 일자를 구하라
select ename, adddate(hiredate, interval 3 month) from emp;

-- 67. 사원들의 입사일자 다음 토요일의 일자를 구하라
select ename, next_day(hiredate, 7) from emp;			-- 안됨

-- 68. 사원들의 입사월의 마지막 날짜를 구하라
select ename, last_day(hiredate) from emp;

-- 69. 사원들의 입사일자를 년을 기준으로 반올림하여 구하라
select ename, round(hiredate, -5) from emp;

-- 70. 사원들의 입사일자를 년을 기준으로 절사하여 구하라
select ename, round(hiredate,'d') from emp;				-- 안됨

-- 71. 매니저 없는 사원의 경우 '상급자 없음'을 나타내도록 하는 질의문을 작성하시오
select ename, ifnull(mgr,'상급자 없음') from emp;

-- 72. 커미션이 포함한 급여를 사원번호, 이름과 함께 구하라
select empno, ename, comm, sal from emp;
select empno, ename,
		case when comm is null then sal
        else comm+sal
        end
        '합계'
from emp;


-- 73. 커미션을 포함한 연봉(급여x12)을 사원번호, 이름과 함께 구하라
select empno, ename, 
		case when comm is null then sal *12
		else sal*12+comm
        end
        '연봉'
 from emp;

-- 74. 매니저가 NULL인 경우 'CEO'로 바꾸어 사원번호, 이름, 매니저를 구하라
select empno, ename, ifnull(mgr, 'CEO') from emp;

-- 75. 10, 20번 부서 사원들 중 최고 급여를 받는 사원의 사원번호, 이름, 급여를 구하라
-- 선생님
SELECT * FROM emp;
SELECT empno, ename, sal FROM emp;
SELECT deptno, max(sal) FROM emp WHERE deptno IN (10,20) group by deptno;

SELECT empno, ename, sal FROM emp WHERE (deptno, sal) 
IN (SELECT deptno, max(sal) FROM emp WHERE deptno IN (10,20) group by deptno);

-- 나
select empno, ename, max(sal) from emp GROUP BY deptno;
select empno, ename, sal, deptno from emp where sal = ((select max(sal) from emp) and deptno=10 and deptno =20);

-- 76. 30번 부서의 사원 중 최저 급여를 받는 사원의 사원번호, 이름, 급여를 구하라
SELECT empno, ename, sal from emp where(deptno, sal)
in (select deptno, min(sal) from emp where deptno=30);

-- 77. 전체 사원들 중 최고 커미션을 받는 사원의 사원번호, 이름, 커미션을 구하라
select empno, ename, comm from emp where max(comm);
select comm from emp where max(comm);

-- 78. 전체 사원들 중 최저 커미션을 받는 사원의 사원번호, 이름, 커미션을 구하라

-- 79. 전체 사원의 이름 중 최고값과 최저값을 검색하라

-- 80. 전체 사원의 입사일자 중 최고값과 최저값을 검색하라

-- 81. 사원번호의 최고값과 최소값을 검색하라

-- 82. 매니저 컬럼의 데이터 개수를 검색하라

-- 83. 이름의 개수를 검색하라

-- 84. 사원테이블의 튜플 수를 검색하라

-- 85. 부서 테이블의 튜플 수를 검색하라

-- 86. 커미션의 개수를 검색하라

-- 87. 부서별 사원들의 인원수를 검색하라

-- 88. 매니저별 사원들의 인원수를 검색하라

-- 89. 부서별 사원들의 평균 급여를 검색하라

-- 90. 부서별 사원들의 급여의 표준편차를 검색하라

-- 91. 부서별 직무별 사원의 급여 합을 검색하라

-- 92. 부서별 직무별 사원들의 평균 급여를 검색하라

-- 93. 부서별 직무별 사원들의 입사일자의 최고값과 최저값을 검색하라

-- 94. 부서별 사원들의 인원수를 인원수가 많은 순으로 검색하라

-- 95. 부서별 사원들의 평균 급여를 평균 급여 순으로 검색하라

-- 96. 부서별 직무별 사원의 급여 합을 많은 순으로 검색하라

-- 97. 부서별 직무별 사원들의 평균 급여를 평균 급여가 많은 순으로 검색하라

-- 98. 사원번호, 이름, 부서명을 검색하라

-- 99. 부서지역이 NEW YORK인 사원의 이름을 검색하라

-- 100. ADAMS 사원이 근무 중인 부서명과 지역을 검색하라

-- 101. 급여가 2000 이상인 사원들의 사원명과 지역을 검색하라

-- 102. 직무가 SALESMAN이면서 CHICAGO에 근무 중인 사원명을 검색하라

-- 103. NEW YORK과 DALLAS에 근무하는 사원들의 사번과 이름을 사원번호순으로 검색하라

-- 104. 부서명이 ACCOUNTING 이거나, 지역이 CHICAGO인 사원의 사원번호와 이름을 검색하라

-- 105. 사원번호, 이름, 급여, 급여등급을 검색하라

-- 106. 각 사원의 사원번호와 이름, 매니저 사원번호와 이름을 검색하라

-- 107. BLAKE 사원보다 많은 급여를 받는 사원의 이름을 검색하라

-- 108. FORD 사원과 같은 부서에 근무하는 사원의 이름을 검색하라

-- 109. FORD 사원과 같은 급여를 받는 사원의 사원번호를 검색하라

-- 110. 부서별 인원수를 부서명과 함께 검색하라

-- 111. 부서명이 'SALES'이면서 직무가 'MANAGER'인 사원의 사원번호, 이름을 이름순으로 검색하라

-- 112. SCOTT 사원보다 많은 급여를 받는 사원 정보를 검색하라

-- 113. ALLEN 사원보다 적은 급여를 받는 사원 정보를 검색하라

-- 114. 20번 부서 사원의 직무와 같은 직무를 하고 있는 다른 부서의 사원 정보를 검색하라

-- 115. 전체 사원의 평균 급여보다 급여가 많은 사원 정보를 검색하라

-- 116. 급여가 모든 부서들의 평균 급여보다 많은 사원 정보를 검색하라

-- 117. 20번 부서의 최대 급여보다 최대 급여가 큰 부서의 번호와, 최대 급여를 검색하라

-- 118. CHICAGO에 위치하는 부서에 근무하는 사원 정보를 검색하라(서브쿼리 이용)