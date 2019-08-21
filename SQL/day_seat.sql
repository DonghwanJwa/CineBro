CREATE TABLE day_seat(										--예매좌석 테이블
seat_status NUMBER(5) NOT NULL								--예매유무(0,1)
,seat_Num VARCHAR2(10) REFERENCES seat(seat_Num)			--좌석코드
,screen VARCHAR2(30) REFERENCES cinema(screen)				--상영관
,time_code VARCHAR2(40) REFERENCES movietime(time_code)		--시간코드
);

--drop table day_seat;

-- alt+c 단축키로 실행 !!
declare
	dat NUMBER(20);		--0826~0828에서 6~8만
	scr NUMBER(20);		--관 번호
	tco NUMBER(20);		--회차 (08261~08265에서 1~5만)
	row NUMBER(20);		--좌석 행
	col NUMBER(20);		--좌석 열
begin
for dat in 6..8 LOOP
	for scr in 1..12 LOOP
		for tco in 1..5 LOOP
			for row in 65..76 LOOP
				for col in 1..20 LOOP
					insert into day_seat (seat_status,seat_Num,screen,time_code)
					values (0,scr||'관'||CHR(row)||col,scr||'관',scr||'관082'||dat||tco);
				end LOOP;
			end LOOP;
		end LOOP;
	end LOOP;
end LOOP;
end; 

select * from day_seat where time_code='1관08261'

UPDATE day_seat SET seat_status=0 WHERE seat_Num='1관F10' AND time_code='1관08261';

