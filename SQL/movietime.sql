
CREATE TABLE movietime(									--상영일정 테이블
time_code VARCHAR2(40) PRIMARY KEY						--시간코드(상영관+상영일자+숫자 형식?)
,screentime VARCHAR2(20) NOT NULL						--상영시간
,screendate DATE NOT NULL								--상영일자
,movie_code NUMBER REFERENCES MovieData(movie_code)		--영화코드
,screen VARCHAR2(30) REFERENCES cinema(screen)			--상영관
);