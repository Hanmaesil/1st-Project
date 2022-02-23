드랍

drop table member cascade constraints;
drop table drinksort cascade constraints;
drop table drinkinfo cascade constraints;
drop table taste cascade constraints;
drop table flavor cascade constraints;
drop table board cascade constraints;
drop sequence board_num_seq;
drop table reply cascade constraints;
drop sequence reply_index_seq
drop sequence reply_reorder_seq
drop table list cascade constraints;
drop sequence rereply_listorder_seq
drop table sidemenu cascade constraints;

drop table board_test2
drop table des cascade constraints;
drop table jjimlist_test cascade constraints;
drop table member_test cascade constraints;
drop table re_reply cascade constraints;
drop table reply_test cascade constraints;
drop table test3 cascade constraints;
drop table worldcupdto cascade constraints;

--  회원정보 테이블
create table member ( 
id varchar2(20), 
pw varchar2(20) not null,
 nick varchar2(20) not null unique, 
phone varchar2(12) not null,
 birthday date not null,
 sex number(1) not null,
 constraint member_id_pk primary key(id)
 );
 select * from member
 
-- 술 종류 테이블
create table drinkSort(
sort number(2),
constraint drinkSort_sort_pk primary key(sort)
); 

select * from drinksort
insert into drinksort values(3);
insert into drinksort values(4);
insert into drinksort values(5);
insert into drinksort values(6);
insert into drinksort values(7);
insert into drinksort values(8);
insert into drinksort values(9);
insert into drinksort values(10);



-- 술 정보 테이블
create table drinkInfo ( 
dr_num number(5),
sort number(2) ,
dr_id varchar2(300), 
dr_flavor varchar2(1200),
dr_taste varchar2(1200), 
dr_abv number(5),
dr_des varchar2(2000),
dr_img clob,
constraint drinkInfo_idnum_pk primary key(dr_id, dr_num),
constraint drinkInfo_sort_fk foreign key(sort)
references drinkSort(sort)
);

select * from drinkinfo
drop table drinkInfo


-- 초성별 맛 저장 테이블
create table taste(
num number(5) not null,
sort number(2),
a varchar(100),
b varchar(100),
c varchar(100),
d varchar(100),
e varchar(100),
f varchar(100),
g varchar(100),
h varchar(100),
i varchar(100),
j varchar(100),
k varchar(100),
l varchar(100),
m varchar(100),
n varchar(100),
constraint taste_num_pk primary key(num),
constraint taste_sort_fk foreign key(sort)
references drinkSort(sort)
);
 
select * from taste

-- 초성별 향 저장 테이블
create table flavor(
num number(5) not null,
sort number(2),
a varchar(100),
b varchar(100),
c varchar(100),
d varchar(100),
e varchar(100),
f varchar(100),
g varchar(100),
h varchar(100),
i varchar(100),
j varchar(100),
k varchar(100),
l varchar(100),
m varchar(100),
n varchar(100),
constraint flavor_num_pk primary key(num),
constraint flavor_sort_fk foreign key(sort)
references drinkSort(sort)
);

select * from flavor
 

-- 게시판 테이블
create table board (
bo_num number(10) not null , 
nick varchar2(20) not null,
bo_title varchar2(50) not null, 
bo_content varchar2(500) not null, 
bo_date date , 
constraint board_id_pk primary key(bo_num),
constraint board_nick_fk foreign key(nick)
references member(nick)
);

-- 게시글 번호 시퀀스
create sequence board_num_seq
increment by 1
nocache;

select * from board

-- 댓글 테이블

create table reply (
reorder number(5) not null,
bo_num number(10) not null, 
nick varchar2(20) not null, 
re_comment varchar2(100) ,
regdate date,
re_index number(3) not null,
constraint reply_reorder_pk primary key(reorder),
constraint reply_num_fk foreign key(bo_num)
references board(bo_num),
constraint reply_nick_fk foreign key(nick)
references member(nick)
);

-- 댓글번호 시퀀스

create sequence reply_index_seq
increment by 1
nocache;

-- 댓글 순서 

create sequence reply_reorder_seq
increment by 1
nocache;

select * from reply


-- 추천 테이블
create table list(
list_order number(5) not null,
dr_num number(5),
nick varchar2(20),
sort number(2),
dr_id varchar2(300),
count number(1),
dr_flavor varchar2(1200),
dr_taste varchar2(1200),
dr_abv number(5),
dr_img clob,
constraint list_listorder_pk primary key(list_order),
constraint list_nick_fk foreign key(nick)
references member(nick),
constraint list_sort_fk foreign key(sort)
references drinkSort(sort),
constraint list_idnum_fk foreign key(dr_id,dr_num)
references drinkInfo(dr_id, dr_num)
);


-- 순서 시퀀스
create sequence list_listorder_seq
increment by 1
nocache;

select * from list
delete from list where count = 0

-- 안주 테이블
create table sidemenu (
s_id varchar2(50) not null , 
s_img clob,
constraint sidemenu_id_pk primary key(s_id)
);

select * from sidemenu

-- 술 기본정보 설명 테이블
create table drinkdes(
sort number(2),
des_des varchar2(1000),
des_img clob,
constraint des_sort_pk primary key(sort),
constraint des_sort_fk foreign key(sort)
references drinksort(sort)
);


select * from member
select * from des
select * from 


delete from member, reply where nick = '최종인2'
 