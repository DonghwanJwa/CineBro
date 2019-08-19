CREATE TABLE day_seat(										--예매좌석 테이블
seat_status NUMBER(5) NOT NULL								--예매유무(0,1)
,seat_Num VARCHAR2(10) REFERENCES seat(seat_Num)			--좌석코드
,screen VARCHAR2(30) REFERENCES cinema(screen)				--상영관
,time_code VARCHAR2(40) REFERENCES movietime(time_code)		--시간코드
);

--drop table day_seat;

-- alt+c 단축키로 실행 !!
declare
	dat NUMBER(20);		--0823~0825에서 3~5만
	scr NUMBER(20);		--관 번호
	tco NUMBER(20);		--회차 (08231~08235에서 1~5만)
	low NUMBER(20);		--좌석 행
	col NUMBER(20);		--좌석 열
begin
for dat in 3..5 LOOP
	for scr in 1..12 LOOP
		for tco in 1..5 LOOP
			for low in 65..76 LOOP
				for col in 1..20 LOOP
					insert into day_seat (seat_status,seat_Num,screen,time_code)
					values (0,scr||'관'||CHR(low)||col,scr||'관',scr||'관082'||dat||tco);
				end LOOP;
			end LOOP;
		end LOOP;
	end LOOP;
end LOOP;
end; 

select * from day_seat where time_code='1관08231';

