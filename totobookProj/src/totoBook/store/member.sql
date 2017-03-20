--DROP TABLE MEMBER_TB;

CREATE TABLE member_tb (
  member_id varchar2(50),
  name varchar2(50),
  password varchar2(50),
  address varchar2(50),
  phoneNumber varchar2(50),
  receiveEmail varchar2(50),
  PRIMARY KEY (member_id)
);

insert into member_tb(member_id, name, password, address, phoneNumber, receiveEmail) values ('RURE1114','김주희','1234','서울시 구로구','010-1234-1234','true');
insert into member_tb(member_id, name, password, address, phoneNumber, receiveEmail) values ('Lee@Lee.com','이승건','4321','서울시 광진구','010-1111-1111','true');


commit;