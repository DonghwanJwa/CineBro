CREATE TABLE booked_seat(
booking_code NUMBER(38) REFERENCES Booking(booking_code)
,screen VARCHAR2(30) REFERENCES cinema(screen)
,seat_Num VARCHAR2(10) REFERENCES seat(seat_Num)
);