CREATE TABLE day_seat(
seat_status NUMBER(5) NOT NULL
,seat_Num VARCHAR2(10) REFERENCES seat(seat_Num)
,screen VARCHAR2(30) REFERENCES cinema(screen)
,time_code VARCHAR2(40) REFERENCES movietime(time_code)
);