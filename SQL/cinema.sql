
CREATE TABLE cinema(
screen VARCHAR2(30) PRIMARY KEY
,movie_code NUMBER REFERENCES MovieData(movie_code)
);

DROP TABLE cinema;