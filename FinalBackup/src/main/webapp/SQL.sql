select * from test2

INSERT INTO TEST (SORT, DR_ID, DR_FLAVOR, DR_TASTE, DR_ABV, DR_DES, DR_IMG) VALUES (1,'���̽� fresh','','',16,'�볪�� ������ 4�� �ɷ� �� ������ ��ѱ�� �̽������� � �󺧷� ���� Ʈ�������� ���̽�fresh �Դϴ�.','https://image.ajunews.com/content/image/2021/03/16/20210316093808706983.png');

select * from test3


select * from test2 where sort = 10

INSERT INTO TEST (SORT, DR_ID, DR_FLAVOR, DR_TASTE, DR_ABV, DR_DES, DR_IMG) VALUES (2, '���� ����Ŭ����', '', '', '4', 'Super-Yeast�� ���� ������ ����� ���� ��� ������ �Բ��ص� ���� ����', 'https://company.lottechilsung.co.kr/common/images/lyPopProd_alcohol02List03.jpg')



select * from test2 where sort =10 and dr_abv = 11



select * from MEMBER_TEST

select birthday from MEMBER_TEST

insert into MEMBER_TEST values('test', '1234', 'test', '01000000000', '19931004', 1)

delete from member_test where id = 'test' and pw = '1234'

select * from BOARD_TEST

select nick, title from board_test


select * from REPLY_TEST


create table WorldCupDTO(
num number(5),
name varchar(10),
link clob,
choicecnt number(3),
constraint wor_number_pk primary key(num)

)

select * from WORLDCUPDTO

select * from LIST_TEST

select * from BOARD_TEST

create table board_test2(
bo_num number(10),
nick varchar(20),
bo_title varchar(50),
bo_content varchar(500),
bo_date date

)

drop table board_test2

select * from board_test2


select * from des

create sequence board2_num_seq
increment by 1
nocache

update board_test2 set bo_title = '�׽�Ʈ22', bo_content = '�׽�Ʈ22' where bo_num = 2


delete from board_test2 where bo_num = 6 and nick = '�׽�Ʈ���'
