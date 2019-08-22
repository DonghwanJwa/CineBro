CREATE TABLE booked_seat(									--예매한 좌석 테이블(예매한 티켓정보 테이블)
booking_code NUMBER(38)										--예매코드
,screen VARCHAR2(30) REFERENCES cinema(screen)				--상영관
,seat_Num VARCHAR2(10) REFERENCES seat(seat_Num)			--좌석코드
);

drop table booked_seat;
--테이블 생성 후 아래 ALTER문 실행 해줄 것!
ALTER TABLE booked_seat 
ADD CONSTRAINT booked_seat_booking_code_fk
FOREIGN KEY  (booking_code) REFERENCES Booking(booking_code) ON DELETE CASCADE;

SELECT * FROM BOOKED_SEAT ORDER BY seat_Num;

DELETE FROM BOOKED_SEAT;