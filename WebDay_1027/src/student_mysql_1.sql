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
-- 복합기본키 수정
-- alter table tbl_student_201905 add primary key (syear,sclass, sno);

create table tbl_dept_201905(
    syear char(1) , 
    sclass char(2) , 
    tname varchar(20),
    primary key(syear,sclass)
);
-- alter table tbl_dept_201905 add primary key (syear, sclass);

create table tbl_score_201905(
    syear char(1),	-- fk
    sclass char(2),	-- fk
    sno char(2),	-- fk
    kor int(3),
    eng int(3),
    math int(3),
    foreign key(syear,sclass,sno) references tbl_student_201905(syear,sclass,sno)
);
-- 복합 외래키 설정
ALTER TABLE tbl_score_201905
ADD FOREIGN KEY (syear,sclass, sno) REFERENCES tbl_student_201905(syear,sclass, sno); 
--   또는   -- 
ALTER TABLE tbl_score_201905
ADD FOREIGN KEY (syear,sclass, sno) REFERENCES tbl_student_201905; 


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

insert into tbl_dept_201905(syear,sclass,tname) values('1','01','김교사');
insert into tbl_dept_201905(syear,sclass,tname) values('1','02','이교사');
insert into tbl_dept_201905(syear,sclass,tname) values('1','03','박교사');

insert into tbl_score_201905(syear,sclass,sno,kor,eng,math) values('1','01','01',50,50,50);
insert into tbl_score_201905(syear,sclass,sno,kor,eng,math) values('1','01','02',60,40,100);
insert into tbl_score_201905(syear,sclass,sno,kor,eng,math) values('1','01','03',70,70,70);
insert into tbl_score_201905(syear,sclass,sno,kor,eng,math) values('1','02','01',80,80,80);
insert into tbl_score_201905(syear,sclass,sno,kor,eng,math) values('1','02','02',50,50,50);
insert into tbl_score_201905(syear,sclass,sno,kor,eng,math) values('1','02','03',40,90,80);
insert into tbl_score_201905(syear,sclass,sno,kor,eng,math) values('1','03','01',70,70,70);
insert into tbl_score_201905(syear,sclass,sno,kor,eng,math) values('1','03','02',80,60,90);
insert into tbl_score_201905(syear,sclass,sno,kor,eng,math) values('1','03','03',90,80,70);

commit;


