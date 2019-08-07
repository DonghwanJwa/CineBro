--	영화정보를 저장할 테이블 생성
CREATE TABLE MovieData(
movie_code INT PRIMARY KEY			--영화코드
movie_name VARCHAR2(20) NOT NULL	--영화이름
gerne VARCHAR2(20) NOT NULL			--영화장르
runningTime VACHAR2(20) NOT NULL	--영화시간
Director VARCHAR2(20) NOT NULL		--영화감독
Screentime VARCHAR2(20) NOT NULL	--영화 상영시간
Actors	VARCHAR2(20) NOT NULL		--영화배우

--영화 동영상 주소를 저장할 컬럼생성
Teaser	VARCHAR2(40) 	NOT NULL	--티져영상
1stPreaview	VARCHAR2(40)	NOT NULL--예고편
2ndPreaview	VARCHAR2(40)	NOT NULL

);
