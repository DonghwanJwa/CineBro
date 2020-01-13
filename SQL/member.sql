create table member(						--회원 테이블
 member_id varchar2(20) primary key			--회원아이디
 ,member_pwd varchar2(20) NOT NULL			--비밀번호
 ,member_name varchar2(20) NOT NULL			--회원 이름
 ,member_sex varchar2(20) NOT NULL			--성별
 ,member_birth varchar2(20) NOT NULL		--생일
 ,member_email varchar2(50) NOT NULL UNIQUE	--이메일
);
--암호화 과정 데이터 넣는 과정에서 예상보다 많은 데이터가 들어가므로 사이즈변경
alter table member modify(member_email varchar2(200));

select * from member

DELETE FROM member;