create table tbl_product_202002 (
	p_code char(3), 
	p_name varchar(20) not null, 
	p_size int(4), 
	p_incost int(7), 
	p_outcost int(7), 
	primary key(p_code)
);

insert into tbl_product_202002 values ('B01','경량적색바퀴',150,3000,3600);
insert into tbl_product_202002 values ('B02','중량적색바퀴',200,4000,4800);
insert into tbl_product_202002 values ('B03','우레탄1.0인치',250,2500,3000);
insert into tbl_product_202002 values ('B04','우레탄1.5인치',300,3000,3600);
insert into tbl_product_202002 values ('B05','우레탄2.0인치',350,3500,4200);
insert into tbl_product_202002 values ('B06','우레탄2.5인치',400,4000,4800);

create table tbl_company_202002 (
	c_code char(3), 
	c_name varchar(20) not null, 
	c_tel1 char(3), 
	c_tel2 char(4), 
	c_tel3 char(4), 
	primary key(c_code)
);

insert into tbl_company_202002 values ('10','서울공장','02','1488','1000');
insert into tbl_company_202002 values ('20','울산공장','052','1488','2000');
insert into tbl_company_202002 values ('30','부산상사','051','1488','3000');
insert into tbl_company_202002 values ('40','광주상사','062','1488','4000');
insert into tbl_company_202002 values ('50','대전상사','042','1488','5000');

create table tbl_inout_202002 (
	t_no char(8), 
	p_code char(3) not null,
	t_type char(1), 
	t_cnt int(4), 
	t_date date, 
	c_code char(3) not null, 
	FOREIGN KEY(p_code) REFERENCES TBL_product_202002(p_code),
	FOREIGN KEY(c_code) REFERENCES TBL_company_202002(c_code),
	primary key(t_no)
);

insert into tbl_inout_202002 values ('20200001','B01','I','100','20200101','10');
insert into tbl_inout_202002 values ('20200002','B02','I','100','20200101','10');
insert into tbl_inout_202002 values ('20200003','B03','I','200','20200101','20');
insert into tbl_inout_202002 values ('20200004','B04','I','300','20200101','20');
insert into tbl_inout_202002 values ('20200005','B05','I','400','20200101','20');
insert into tbl_inout_202002 values ('20200006','B06','I','400','20200101','20');
insert into tbl_inout_202002 values ('20200007','B01','O','30','20200102','30');
insert into tbl_inout_202002 values ('20200008','B02','O','25','20200102','40');
insert into tbl_inout_202002 values ('20200009','B03','O','50','20200103','40');
insert into tbl_inout_202002 values ('20200010','B04','O','40','20200104','30');
insert into tbl_inout_202002 values ('20200011','B05','O','60','20200104','50');

commit;

