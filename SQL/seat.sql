CREATE TABLE seat(								--좌석 테이블
seat_Num VARCHAR2(10) PRIMARY KEY				--좌석코드(상영관+좌석번호)
,screen VARCHAR2(30) REFERENCES cinema(screen)	--상영관
,seatrow VARCHAR2(20) NOT NULL					--좌석행
,seatcol VARCHAR2(20) NOT NULL					--좌석열
);

DROP table seat;

--1관~12관, A~L행, 1~20열의 좌석 코드를 넣는 for(loop)문.
--주의!!! 실행시 declare~end;까지 블럭처리 후 alt+c 단축키로 실행 !! (강제적인 한문장 실행처리) 
--실행하고 select * from seat; 실행시 500개의 로우(행)만 나오지만 실제로는 2880개의 
--데이터를 모두 가지고 있음. 이는 맨 하단의 조건select문을 통해서 확인 가능

declare
	scr NUMBER(20);
	row NUMBER(20);
	col NUMBER(20);
begin
	for scr in 1..12 LOOP
		for row in 65..76 LOOP
			for col in 1..20 LOOP
				insert into seat (seat_Num,screen,seatrow,seatcol)
				values (scr||'관'||CHR(row)||col,scr||'관',CHR(row)||'',col||'');
			END LOOP;
		END LOOP;
	END LOOP;
end;

--관수를 변경하면서 빠진 데이터가 없는지 간단히 확인해주세요.
select * from seat where screen='6관' ORDER BY seatrow;














