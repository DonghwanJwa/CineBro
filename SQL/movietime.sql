
CREATE TABLE movietime(
time_code VARCHAR2(40) PRIMARY KEY
,screentime VARCHAR2(20) NOT NULL
,screendate DATE NOT NULL
,movie_code NUMBER REFERENCES MovieData(movie_code)
,screen VARCHAR2(30) REFERENCES cinema(screen)
);