
CREATE TABLE cinema(									--상영관 테이블
screen VARCHAR2(30) PRIMARY KEY							--상영관
,movie_code NUMBER REFERENCES MovieData(movie_code)		--영화코드
);

--DROP TABLE cinema;