
CREATE TABLE Booking(
booking_code NUMBER(38) PRIMARY KEY -- 예약번호
,price NUMBER(10) NOT NULL
,seatcount NUMBER(10) NOT NULL
,movie_code INT REFERENCES MovieData(movie_code)
,member_id VARCHAR2(20) REFERENCES member(member_id)
,time_code VARCHAR2(40) REFERENCES movietime(time_code)
);

CREATE SEQUENCE booked_seq