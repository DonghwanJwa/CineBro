--	영화정보를 저장할 테이블 생성
CREATE TABLE MovieData(
movie_code INT PRIMARY KEY			--영화코드
,movie_nameK VARCHAR2(40) NOT NULL	--영화이름
,movie_nameE VARCHAR2(70) NOT NULL	--영화이름
,movie_img	VARCHAR2(20) NOT NULL	--영화이미지
,audience  	VARCHAR2(100) NOT NULL	--관람객 평점
,criticism	VARCHAR2(50) NOT NULL	--평론가 평점
,gerne 		VARCHAR2(72) NOT NULL	--영화장르(장르, 나라, 러닝타임, 개봉일)
,director 	VARCHAR2(30) NOT NULL	--영화감독
,actors	    VARCHAR2(90) NOT NULL	--영화배우
,age		VARCHAR2(20) NOT NULL	--영화등급
,people	    VARCHAR2(30) NOT NULL	--누적관객수

--영화 동영상 주소를 저장할 컬럼생성
,teaser	      	VARCHAR2(200)    NOT NULL   --티져영상 URL
,oneview		  	VARCHAR2(200)	NOT NULL   --예고편1 URL
,twoview	      	VARCHAR2(200)	NOT NULL   --예고편2 URL
,threeview	    VARCHAR2(200)	NOT NULL   --예고편3 URL
,teaser_img 	  	VARCHAR2(40) 	NOT NULL   --티저이미지
,oneview_img   	VARCHAR2(40)	NOT NULL   --예고편1 이미지
,twoview_img	  	VARCHAR2(40)  	NOT NULL   --예고편2 이미지
,threeview_img   VARCHAR2(40) 	NOT NULL   --예고편3 이미지
);
--DROP Table MovieData;
INSERT INTO MovieData VALUES(
'01','엑시트','Exit',
'1movie.jpg',' 관람객    ★★★★☆  8.42  네티즌  ★★★☆☆  6.43','평론가    ★★★★☆  8.11',
'액션,코미디   한국   103분   2019.07.31개봉','이상근','조정석(용남), 윤아(의주), 고두심(현옥)',
'12세 관람가','누적관객 4,532,156명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView
.nhn?code=174903&mid=42940#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=174903&mid=
42749#tab',
'C:\\Program Files\\Internet Explorer\\
iexplore.exe\"https://movie.naver.com/
movie/bi/mi/mediaView.nhn?code=174903&mid=43119#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.n
hn?code=174903&mid=43013#tab',
'1video1.jpg','1video2.jpg','1video3.jpg','1video4.jpg');
INSERT INTO MovieData VALUES(
'02','봉오동 전투','The Battle: Roar to Victory, 2019',
'2movie.jpg','관람객    ★★★★★  9.80  네티즌  ★★★★☆  7.21','평론가    ★★★☆☆  5.17',
'액션,드라마   한국   135분   2019.08.07개봉','원신연','유해진(황해철),류준열(이장하),
조우진(마병구)','15세 관람가','누적관객 18,403명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
178526&mid=43048#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
178526&mid=42906#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
178526&mid=42780#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
178526&mid=43251#tab',
'2video1.jpg','2video2.jpg','2video3.jpg','2video4.jpg');
INSERT INTO MovieData VALUES(
'03','마이펫의 이중생활2','The Secret Life of Pets 2, 2019',
'3movie.jpg','관람객    ★★★★★  9.14  네티즌  ★★★★☆  8.98','평론가    ★★★☆☆  6.00',
'애니메이션,코미디   미국   85분   2019.07.31개봉','크리스 리노드','패튼 오스왈트(맥스 목소리)
,케빈 하트(스노우볼 목소리)','전체 관람가','누적관객 743,399명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
180374&mid=43097#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
180374&mid=43094#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
180374&mid=43085#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
180374&mid=43084#tab',
'3video1.jpg','3video2.jpg','3video3.jpg','3video4.jpg');
INSERT INTO MovieData VALUES(
'04','라이온킹','The Lion King, 2019',
'4movie.jpg','관람객    ★★★★☆ 8.70  네티즌  ★★★★☆  8.29','평론가    ★★★☆☆  6.00',
'모험,드라마   미국   118분   2019.07.17개봉','존 파브로','도날드 글로버(심바 목소리,
비욘세(날라 목소리)','전체 관람가','누적관객 4,581,793명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
169637&mid=43003#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
169637&mid=42969#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
169637&mid=42926#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
169637&mid=42897#tab',
'4video1.jpg','4video2.jpg','4video3.jpg','4video4.jpg');
INSERT INTO MovieData VALUES(
'05','레드슈즈','Red Shoes, 2019',
'5movie.jpg','관람객    ★★★★★ 9.23  네티즌  ★★★★★  9.32','평론가    ★★★☆☆  6.00',
'애니메이션,모험   한국   92분   2019.07.25개봉','홍성호','클로이 모레츠(스노우 화이트 목소리)
,샘 클라플린(멀린 목소리)','전체 관람가','누적관객 576,995명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
164907&mid=42913#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
164907&mid=42833#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
164907&mid=42791#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
164907&mid=42664#tab',
'5video1.jpg','5video2.jpg','5video3.jpg','5video4.jpg');
INSERT INTO MovieData VALUES(
'06','사자','The Divine Fury, 2019',
'6movie.jpg','관람객    ★★★★☆ 8.34  네티즌  ★★★★☆  7.23','평론가    ★★☆☆☆  4.78',
'미스터리,액션  한국   129분   2019.07.31개봉','김주환','박서준(용후)
,안성기(안신부),우도환(지신)','15세 관람가','누적관객 1,348,023명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
178544&mid=43106#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
178544&mid=42762#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
178544&mid=42227#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
178544&mid=43273#tab',
'6video1.jpg','6video2.jpg','6video3.jpg','6video4.jpg');
INSERT INTO MovieData VALUES(
'07','알라딘','Aladdin, 2019',
'7movie.jpg','관람객    ★★★★★ 9.45  네티즌  ★★★★★  9.43','평론가    ★★★☆☆  6.00',
'모험,가족  미국   128분   2019.05.23개봉','가이 리치','메나 마수드(알라딘),
윌 스미스(지니)','전체 관람가','누적관객 12,312,715명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
163788&mid=42185#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
163788&mid=41880#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
163788&mid=40574#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
163788&mid=42564#tab',
'7video1.jpg','7video2.jpg','7video3.jpg','7video4.jpg');
INSERT INTO MovieData VALUES(
'08','주전장','Shusenjo: The Main Battleground of Comfort Women Issue, 2018',
'8movie.jpg','관람객    ★★★★★ 9.70  네티즌  ★★★★★  9.51','평론가    ★★★☆☆  7.33',
'다큐멘터리  미국   121분   2019.07.25개봉','미키 데자키','미키 데자키',
'전체 관람가','누적관객 18,323명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
179518&mid=43179#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
179518&mid=42896#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
179518&mid=42810#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
179518&mid=42624#tab',
'8video1.jpg','8video2.jpg','8video3.jpg','8video4.jpg');
INSERT INTO MovieData VALUES(
'09','나랏말싸미','The King''s Letters, 2019',
'9movie.jpg','관람객    ★★★☆☆ 7.03  네티즌  ★★☆☆☆  3.51','평론가    ★★★☆☆  6.45',
'드라마  한국   110분   2019.07.24개봉','조철현','송강호(세종대왕),
박해일(신미 스님)','전체 관람가','누적관객 941,423명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
173668&mid=42929#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
173668&mid=42831#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
173668&mid=42693#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
173668&mid=42649#tab',
'9video1.jpg','9video2.jpg','9video3.jpg','9video4.jpg');
INSERT INTO MovieData VALUES(
'10','스파이더맨: 파 프롬 홈','Spider-Man: Far From Home, 2019',
'10movie.jpg','관람객    ★★★★★ 9.00  네티즌  ★★★★☆  8.37','평론가    ★★★☆☆  6.56',
'액션,모험  미국   129분   2019.07.02개봉','존 왓츠','톰 홀랜드(피터 파커 / 스파이더맨),
사무엘L.잭슨(닉퓨리)','12세 관람가','누적관객 8,008,505명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
173123&mid=42823#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
173123&mid=42733#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
173123&mid=42655#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
173123&mid=42365#tab',
'10video1.jpg','10video2.jpg','10video3.jpg','10video4.jpg');
INSERT INTO MovieData VALUES(
'11','기생충','PARASITE, 2019',
'11movie.jpg','관람객    ★★★★★ 9.07  네티즌  ★★★★☆  8.49','평론가    ★★★★★  9.06',
'드라마  한국   131분   2019.05.30개봉','봉준호','송강호(기택),이선균(동익),
조여정(연교)','15세 관람가','누적관객 10,071,277명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
161967&mid=42375#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
161967&mid=42092#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
161967&mid=43137#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
161967&mid=42767#tab',
'11video1.jpg','11video2.jpg','11video3.jpg','11video4.jpg');
INSERT INTO MovieData VALUES(
'12','누구나 아는 비밀','Todos lo saben, Everybody Knows, 2018',
'12movie.jpg','관람객    ★★★★★ 9.00  네티즌  ★★★★☆  8.08','평론가    ★★★☆☆  6.83',
'드라마  스페인,프랑스,이탈리아   133분   2019.08.01개봉','아쉬가르 파라디',
'페넬로페 크루즈(라우라),하비에르 바르뎀(파코)','15세 관람가','누적관객 15,014명',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
168054&mid=42883#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
168054&mid=42847#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
168054&mid=43182#tab',
'C:\\Program Files\\Internet Explorer\\iexplore.exe\
"https://movie.naver.com/movie/bi/mi/mediaView.nhn?code=
168054&mid=43096#tab',
'12video1.jpg','12video2.jpg','12video3.jpg','12video4.jpg');

SELECT * FROM MovieData;
