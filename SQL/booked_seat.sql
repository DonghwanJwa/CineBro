CREATE TABLE booked_seat(									--예매한 좌석 테이블(예매한 티켓정보 테이블)
booking_code NUMBER(38) REFERENCES Booking(booking_code)	--예매코드
,screen VARCHAR2(30) REFERENCES cinema(screen)				--상영관
,seat_Num VARCHAR2(10) REFERENCES seat(seat_Num)			--좌석코드
);

--drop table booked_seat;