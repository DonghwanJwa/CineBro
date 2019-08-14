
CREATE TABLE cinema(									--상영관 테이블
screen VARCHAR2(30) PRIMARY KEY							--상영관
,movie_code NUMBER REFERENCES MovieData(movie_code)		--영화코드
);

--DROP TABLE cinema;

INSERT INTO cinema(screen,movie_code) VALUES('1관',1);
INSERT INTO cinema(screen,movie_code) VALUES('2관',2);
INSERT INTO cinema(screen,movie_code) VALUES('3관',3);
INSERT INTO cinema(screen,movie_code) VALUES('4관',4);
INSERT INTO cinema(screen,movie_code) VALUES('5관',5);
INSERT INTO cinema(screen,movie_code) VALUES('6관',6);
INSERT INTO cinema(screen,movie_code) VALUES('7관',7);
INSERT INTO cinema(screen,movie_code) VALUES('8관',8);
INSERT INTO cinema(screen,movie_code) VALUES('9관',9);
INSERT INTO cinema(screen,movie_code) VALUES('10관',10);
INSERT INTO cinema(screen,movie_code) VALUES('11관',11);
INSERT INTO cinema(screen,movie_code) VALUES('12관',12);

SELECT * FROM cinema WHERE movie_code=5