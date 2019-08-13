
CREATE TABLE Booking(										--예매 테이블
booking_code NUMBER(38) PRIMARY KEY 						--예약번호
,price NUMBER(10) NOT NULL									--금액
,seatcount NUMBER(10) NOT NULL								--좌석 수
,movie_code INT REFERENCES MovieData(movie_code)			--영화코드
,member_id VARCHAR2(20) REFERENCES member(member_id)		--회원아이디
,time_code VARCHAR2(40) REFERENCES movietime(time_code)		--시간코드
);

CREATE SEQUENCE booked_seq