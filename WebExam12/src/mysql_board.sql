CREATE TABLE `tbl_board_01` (
  idx int NOT NULL auto_increment,	--  고유번호
  name varchar(20) NOT NULL ,		--  작성자 이름
  pass varchar(20) NOT NULL ,		--  비밀번호
  subject varchar(100) NOT NULL,	--  제목
  contents text NOT NULL,			--  내용
  readcnt int default 0 ,			--  조회수
  regdate datetime NOT NULL ,		--  작성일자
  PRIMARY KEY  (`idx`)
);

CREATE TABLE `tbl_board_02` (
  idx int NOT NULL auto_increment,		--  고유번호
  name varchar(20) NOT NULL ,			--  작성자 이름
  pass varchar(20) NOT NULL ,			--  비밀번호
  subject varchar(100) NOT NULL,		--  제목
  contents text NOT NULL,			--  내용
  readcnt int default 0 ,			--  조회수
  regdate datetime default CURRENT_TIMESTAMP,	--  작성일자
  PRIMARY KEY  (`idx`)
);

