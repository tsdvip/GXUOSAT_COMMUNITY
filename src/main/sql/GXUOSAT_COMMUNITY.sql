--�û���ɫ��
CREATE TABLE GX_ROLE (
  roleid NUMBER(10) NOT NULL PRIMARY KEY,
  rolename VARCHAR2(20) NOT NULL,
  description VARCHAR2(200)
);

--�û���
CREATE TABLE GX_USER (
  userid NUMBER(10) NOT NULL PRIMARY KEY ,
  roleid NUMBER(10) NOT NULL ,
  username VARCHAR2(20) NOT NULL,
  password VARCHAR2(20) NOT NULL,
  nickname VARCHAR2(50) NOT NULL,
  face VARCHAR2(20) NOT NULL,
  sex VARCHAR2(2) NOT NULL,
  phone VARCHAR2(20) NOT NULL,
  email VARCHAR2(100) NOT NULL,
  address VARCHAR2(200),
  CONSTRAINT PK_GX_USER_REFE FOREIGN KEY(roleid) REFERENCES GX_ROLE(roleid)
);

--����б�
CREATE TABLE GX_BOARD(
  boardid NUMBER(10) NOT NULL,
  boardname VARCHAR2(20) NOT NULL,
  masterid NUMBER,
  PRIMARY KEY (boardid),
  FOREIGN KEY (masterid) REFERENCES GX_USER(userid)
);

--�����б�
CREATE TABLE GX_POST (
  postid NUMBER NOT NULL ,
  userid NUMBER NOT NULL,
  boardid NUMBER NOT NULL,
  title VARCHAR2(100) NOT NULL,
  content VARCHAR2(2000) ,
  posttime VARCHAR2(50) NOT NULL,
  is_top VARCHAR2(1),
  to_top_time VARCHAR2(50),
  is_good VARCHAR2(1),
  to_good_time VARCHAR2(50),
  PRIMARY KEY (postid),
  FOREIGN KEY (boardid) REFERENCES GX_BOARD(boardid)
);

--�ظ��б�
CREATE TABLE GX_POST_ANSWER(
  answerid NUMBER NOT NULL,
  postid NUMBER NOT NULL,
  userid NUMBER NOT NULL,
  content VARCHAR2(200) NOT NULL,
  answertime VARCHAR2(50) NOT NULL,
  PRIMARY KEY (answerid),
  FOREIGN KEY (postid) REFERENCES GX_POST(postid)
);

INSERT INTO GX_ROLE (roleid,rolename,description) VALUES ('1','ϵͳ����Ա','ϵͳ����Ա');
INSERT INTO GX_ROLE (roleid,rolename,description) VALUES ('2','����','');
INSERT INTO GX_ROLE (roleid,rolename,description) VALUES ('3','��ͨ�û�','');

INSERT INTO GX_USER VALUES('1','1','admin','admin','ϵͳ����Ա','1.jpg','��','18888888888','8888@126.com','�㶫����');

INSERT INTO GX_BOARD VALUES ('1','��������','1','Ϊ�л�֮���������');
INSERT INTO GX_BOARD VALUES ('2','ѧϰ����','1','Ϊ�л�֮���������');


INSERT INTO GX_POST(postid,userid,boardid,title,content,posttime) VALUES ('1','1','2','���ѧϰJava','��ߣ���롣','2017-03-24 16:01:00');

create table gx_notice(
  noticeid number PRIMARY key,
    ymd varchar2(30),
  content varchar(500),
  postTime TIMESTAMP
);
