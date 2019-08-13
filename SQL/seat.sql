
CREATE TABLE seat(								--좌석 테이블
seat_Num VARCHAR2(10) PRIMARY KEY				--좌석번호
,screen VARCHAR2(30) REFERENCES cinema(screen)	--상영관
);

















