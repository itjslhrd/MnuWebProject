
create table tbl_student_001 (
	hakbun decimal(4) not null primary key,
	name varchar(20) not null,
	phone1 char(3),
	phone2 char(4),
	phone3 char(4),
	birth char(8),
	gender char(1) check (gender in ('M','F')),
	regdate date
);




insert into tbl_student_001 values(1101,'김자바','010','1111','2222','19971107','M','20171101');
insert into tbl_student_001 values(1102,'강등심','010','2222','1111','19981025','F','20171101');
insert into tbl_student_001 values(1201,'홍장기','010','3333','1111','19971223','M','20171101');
insert into tbl_student_001 values(1202,'최해원','010','4444','1234','19951111','F','20171103');
insert into tbl_student_001 values(2101,'윤길우','010','1234','1234','19941111','M','20171103');
insert into tbl_student_001 values(2102,'장길산','010','2222','1234','19931111','M','20171105');
insert into tbl_student_001 values(3101,'홍길동','010','2323','3434','19910809','M','20171105');
insert into tbl_student_001 values(3102,'박대수','010','2233','4455','19911211','F','20171110');
insert into tbl_student_001 values(3201,'오지랍','010','1222','3111','19900707','M','20171115');


