CREATE TABLE day_seat(										--예매좌석 테이블
seat_status NUMBER(5) NOT NULL								--예매유무(0,1)
,seat_Num VARCHAR2(10) REFERENCES seat(seat_Num)			--좌석코드
,screen VARCHAR2(30) REFERENCES cinema(screen)				--상영관
,time_code VARCHAR2(40) REFERENCES movietime(time_code)		--시간코드
);

--drop table day_seat;