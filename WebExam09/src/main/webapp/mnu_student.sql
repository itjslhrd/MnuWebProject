create table tbl_student_201905(
    syear char(1) not null,
    sclass char(2) not null,
    sno char(2) not null,
    sname varchar(20),
    birth char(8),
    gender char(1),
    tel1 char(3),
    tel2 char(4),
    tel3 char(4),
    primary key(syear,sclass, sno) -- 복합기본키 설정
);


insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) 
values('1','01','01','김학생','20020101','F','010','1234','1001');
insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) 
values('1','01','02','이학생','20020201','M','010','1234','1002');
insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) 
values('1','01','03','박학생','20020301','M','010','1234','1003');
insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) 
values('1','02','01','조학생','20020401','M','010','1234','1004');
insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) 
values('1','02','02','유학생','20020501','M','010','1234','1005');
insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) 
values('1','02','03','여학생','20020601','M','010','1234','1006');
insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) 
values('1','03','01','남학생','20020701','F','010','1234','1007');
insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) 
values('1','03','02','황학생','20020801','F','010','1234','1008');
insert into tbl_student_201905(syear,sclass,sno,sname,birth,gender,tel1,tel2,tel3) 
values('1','03','03','전학생','20020901','F','010','1234','1009');


commit;

