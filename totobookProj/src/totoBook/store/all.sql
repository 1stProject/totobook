drop table book_tb;
drop table page_tb;
drop table photo_tb;
drop table print_tb;
drop table review_tb cascade constraints;
drop table order_tb cascade constraints;
drop table product_tb cascade constraints;
drop table option_tb;
DROP TABLE NOTICE_TB;
DROP TABLE QUESTION_TB cascade constraints;
DROP TABLE ANSWER_TB;
drop table comment_tb;
drop table member_tb cascade constraints;

drop sequence answer_seq;
drop sequence book_seq;
drop sequence comment_seq;
drop sequence notice_seq;
drop sequence option_seq;
drop sequence order_seq;
drop sequence page_seq;
drop sequence photo_seq;
drop sequence post_seq;
drop sequence print_seq;
drop sequence product_seq;
drop sequence question_seq;

CREATE TABLE member_tb (
  member_id varchar2(50),
  name varchar2(50),
  password varchar2(50),
  address varchar2(50),
  phone varchar2(50),
  receive_Email varchar2(50),
  PRIMARY KEY (member_id)
);

insert into member_tb(member_id, name, password, address, phone, receive_Email) values ('RURE1114','김주희','1234','서울시 구로구','010-1234-1234','yes');
insert into member_tb(member_id, name, password, address, phone, receive_Email) values ('lsg7626','이승건','4321','서울시 광진구','010-1111-1111','no');
insert into member_tb(member_id, name, password, address, phone, receive_Email) values ('admin','admin','admin','admin','admin','yes');

CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE product_tb(
product_id varchar2(50),
product_name varchar2(50) DEFAULT '상품명',
PRICE INT DEFAULT 0 ,
category varchar2(50),
DETAIL varchar2(1000),
IMAGE_ADDRESS varchar2(50),
PRIMARY KEY (product_id)
);

INSERT INTO PRODUCT_TB(PRODUCT_ID, PRODUCT_NAME, PRICE, category, DETAIL, IMAGE_ADDRESS)
VALUES(PRODUCT_SEQ.NEXTVAL, '사진인화', 5000, 'PRINT', '항상 어디에서도 빛나는 사진들입니다', 'sucessboy.jpg');

INSERT INTO PRODUCT_TB(PRODUCT_ID, PRODUCT_NAME, PRICE, category, DETAIL, IMAGE_ADDRESS)
VALUES(PRODUCT_SEQ.NEXTVAL, '봄의포토북', 5000, 'BOOK', '녹색이 그윽한 봄의 포토북입니다', 'srping.jpg');

INSERT INTO PRODUCT_TB(PRODUCT_ID, PRODUCT_NAME, PRICE, category, DETAIL, IMAGE_ADDRESS)
VALUES(PRODUCT_SEQ.NEXTVAL, '산의포토북', 5000, 'BOOK', '등산하는 풍경 포토북에 담아보세요', 'mountain.jpg');

INSERT INTO PRODUCT_TB(PRODUCT_ID, PRODUCT_NAME, PRICE, category, DETAIL, IMAGE_ADDRESS)
VALUES(PRODUCT_SEQ.NEXTVAL, '여행의포토북', 5000, 'BOOK', '소중한 추억을 담아보세요', 'travel.jpg');
-- upload파일경로 /upload/product

CREATE SEQUENCE option_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE option_tb(
option_id varchar2(50),
option_name varchar2(50),
value varchar2(50),
option_price int,
product_id varchar2(50),
PRIMARY KEY (option_id)
);
ALTER TABLE option_tb
ADD CONSTRAINT option_tb_fk FOREIGN KEY(product_id)
REFERENCES product_tb(product_id);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '지갑용2장', '8.3cm X 5.2cm', 500, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '3X5)', '8.9cm X 12.7cm', 110, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '정사각(4X4)', '10.2cm X 10.2cm', 110, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'D4', '10.2cm X 13.5cm', 140, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '5X7', '12.7cm X 17.7cm', 280, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '8X10', '20.3cm X 25.4cm', 1000, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4', '21cm X 29.7cm', 1000, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '10X15', '25.4cm X 38.1cm', 2000, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '11X14', '27.9cm X 35.6cm', 2000, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A3', '30.5cm X 42cm', 3900, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '정사각(4X4)', '10.2cm X 10.2cm', 110, 1);


INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'Q88정사각형(21X21cm)', '40', 2000, 2);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'Q88정사각형(21X21cm)', '40', 6000, 2);


INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4세로형(21cmX30cm)', '20', 26000, 2);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4세로형(21cmX30cm)', '40', 30000, 2);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4가로형(21cmX30cm)', '20', 26000, 2);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4가로형(21cmX30cm)', '40', 30000, 2);


INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'B5세로형(19cmX25cm)', '20', 26000, 3);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'B5세로형(19cmX25cm)', '40', 30000, 3);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'B5가로형(19cmX25cm)', '20', 26000, 3);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'B5가로형(19cmX25cm)', '40', 30000, 3);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4가로형(30cmX21cm)', '20', 30000, 4);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4가로형(30cmX21cm)', '40', 35000, 4);


INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4세로형(30cmX21cm)', '20', 30000, 4);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4가로형(30cmX21cm)', '40', 35000, 4);

CREATE SEQUENCE order_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE order_tb (
  order_id varchar2(50) NOT NULL,
  member_id varchar2(50),
  order_date Date,
  payment varchar2(50), 
  total_price NUMBER,
  address varchar2(100),
  bookphoto_Id varchar2(50),
  category varchar2(50),
  PRIMARY KEY (order_id)
);
ALTER TABLE order_tb
ADD CONSTRAINT order_tb_fk FOREIGN KEY (member_id)
REFERENCES member_tb (member_id);
CREATE TABLE review_tb (
  member_id varchar2(20) NOT NULL,
  product_id varchar2(20) NOT NULL,
  CONTENT varchar2(400) NOT NULL,
  IMAGE_ADDRESS varchar2(20) DEFAULT null,
  order_id varchar2(20),
  CONSTRAINT PK_REVIEW_TB PRIMARY KEY(ORDER_ID)
);

ALTER TABLE review_tb
ADD CONSTRAINT review_tb_fk FOREIGN KEY(ORDER_ID)
REFERENCES ORDER_TB(ORDER_ID);

-- review 사진폴더 /upload/review 

CREATE SEQUENCE NOTICE_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE question_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE answer_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE NOTICE_TB (
  post_id varchar2(50),
  member_id varchar2(50) DEFAULT '관리자',
  post_name varchar2(50) not null,
  content varchar2(1000) not null,
  image_address varchar2(50),
  image_ext varchar2(50),
 PRIMARY KEY (post_id)
);

INSERT INTO NOTICE_TB(post_id, post_name, content, image_address, image_ext)
VALUES(NOTICE_SEQ.NEXTVAL, '공지사항 : 안녕하세요.', '우리 홈페이지에 온 것을 환영합니다.','image/default01.jpg', '.JPG');

INSERT INTO NOTICE_TB(post_id, post_name, content, image_address, image_ext)
VALUES(NOTICE_SEQ.NEXTVAL, '공지사항 : 배송관련 공지합니다.', '13일 금요일은 배송회사 쉽니다..','image/default01.jpg', '.JPG');

CREATE TABLE QUESTION_TB (
  post_id varchar2(50),
  member_id varchar2(50),
  post_name varchar2(50) not null,
  content varchar2(1000) not null,
  image_address varchar2(50),
  image_ext varchar2(50),
 PRIMARY KEY (post_id)
);

ALTER TABLE QUESTION_TB
ADD CONSTRAINT QUESTION_TB_fk FOREIGN KEY(MEMBER_ID)
REFERENCES MEMBER_TB(MEMBER_ID) ON DELETE CASCADE;

INSERT INTO QUESTION_TB(post_id, member_id, post_name, content, image_address, image_ext)
VALUES(QUESTION_SEQ.NEXTVAL, 'RURE1114', '문의드려요.', '배송언제와요?','image/default01.jpg', '.JPG');

INSERT INTO QUESTION_TB(post_id, member_id, post_name, content, image_address, image_ext)
VALUES(QUESTION_SEQ.NEXTVAL, 'RURE1114', '문의드려요.', '사장이랑 통화하고 싶어요 전화번호가 뭔가요?','image/default01.jpg', '.JPG');

CREATE TABLE ANSWER_TB (
  answer_id varchar2(50),
  content varchar2(50) not null,
  post_id varchar2(50) not null,
 PRIMARY KEY (answer_id)
);

ALTER TABLE ANSWER_TB
ADD CONSTRAINT ANSWER_TB_fk FOREIGN KEY(POST_ID)
REFERENCES QUESTION_TB(POST_ID) ON DELETE CASCADE;

INSERT INTO ANSWER_TB(answer_id, content, post_id)
VALUES(ANSWER_SEQ.NEXTVAL, '지금 가고 있습니다.','1');

INSERT INTO ANSWER_TB(answer_id, content, post_id)
VALUES(ANSWER_SEQ.NEXTVAL, '전화번호는 알려줄수 없습니다.','2');

CREATE SEQUENCE book_seq START WITH 1 INCREMENT BY 1;


CREATE TABLE book_tb (
  book_id varchar2(50),
  book_name varchar2(50) default '포토북 이름',
  member_id varchar2(50) not null,
  product_id varchar2(50) not null,
  save_date date default sysdate,
  book_option varchar2(50),
 PRIMARY KEY (book_id)
);

ALTER TABLE BOOK_TB
ADD CONSTRAINT BOOK_TB_fk FOREIGN KEY(MEMBER_ID)
REFERENCES MEMBER_TB(MEMBER_ID);

ALTER TABLE BOOK_TB
ADD CONSTRAINT BOOK_TB_PRO FOREIGN KEY(PRODUCT_ID)
REFERENCES PRODUCT_TB(PRODUCT_ID);

INSERT INTO BOOK_TB(BOOK_ID, BOOK_NAME, MEMBER_ID, BOOK_OPTION, PRODUCT_ID)
VALUES(BOOK_SEQ.NEXTVAL, '주희의 책', 'RURE1114', '사이즈 : 8*10 , 커버 : 하드 ', '2');

INSERT INTO BOOK_TB(BOOK_ID, BOOK_NAME, MEMBER_ID, BOOK_OPTION, PRODUCT_ID)
VALUES(BOOK_SEQ.NEXTVAL, '거울의 포토북', 'RURE1114', '사이즈 : 10*14 , 커버 : 소프트 ', '3');

INSERT INTO BOOK_TB(BOOK_ID, BOOK_NAME, MEMBER_ID, BOOK_OPTION, PRODUCT_ID)
VALUES(BOOK_SEQ.NEXTVAL, '이건 그냥 포토북', 'RURE1114', '사이즈 : 11*15 , 커버 : 하드 ', '4');
CREATE SEQUENCE page_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE PAGE_TB (
  PAGE_id varchar2(50),
  book_ID varchar2(50) NOT NULL,
  IMAGE_ADDRESS varchar2(50) not null,
 PRIMARY KEY (PAGE_ID)
);

ALTER TABLE PAGE_TB
ADD CONSTRAINT PAGE_TB_fk FOREIGN KEY(book_ID)
REFERENCES BOOK_TB(book_ID);

INSERT INTO PAGE_TB(PAGE_ID, BOOK_ID, IMAGE_ADDRESS)
VALUES(PAGE_seq.nextval, 2, 'images/defaultpage01.jpg');


CREATE SEQUENCE print_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE photo_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE print_tb (
	print_id varchar2(50) NOT NULL,
	member_id varchar2(50),
	product_id varchar2(50),
	print_option varchar2(50),
	price NUMBER,
	PRIMARY KEY (print_id)
);

ALTER TABLE print_tb
ADD CONSTRAINT print_tb_fk FOREIGN KEY (member_id)
REFERENCES member_tb (member_id);

insert into print_tb (print_id, member_id, product_id, print_option) 
values (print_seq.NEXTVAL,'RURE1114', '1','8*8');

CREATE TABLE photo_tb (
	photo_id varchar2(50) NOT NULL,
	image_address varchar2(100),
	amount NUMBER,
	print_id varchar2(50)
);

ALTER TABLE photo_tb
ADD CONSTRAINT photo_tb FOREIGN KEY (print_id)
REFERENCES print_tb (print_id);

insert into print_tb (print_id, member_id, product_id, print_option) 
values (print_seq.NEXTVAL,'RURE1114', '1','8*8');


insert into photo_tb (photo_id, image_address, amount, print_id) 
values (photo_seq.NEXTVAL, '/images/1.jpg', 1, 1);

insert into photo_tb (photo_id, image_address, amount, print_id) 
values (photo_seq.NEXTVAL, '/images/2.jpg', 2, 1);

insert into photo_tb (photo_id, image_address, amount, print_id) 
values (photo_seq.NEXTVAL, '/images/3.jpg', 2, 1);

insert into order_tb (order_id, member_id, order_date, payment, total_price, bookphoto_id, category) 
values (order_seq.NEXTVAL,'RURE1114','2017-3-15','신용카드', '9000', '1', '사진');
insert into order_tb (order_id, member_id, order_date, payment, total_price, bookphoto_id, category) 
values (order_seq.NEXTVAL,'RURE1114','2017-3-17','현금', '5670', '1', '포토북');
insert into order_tb (order_id, member_id, order_date, payment, total_price, bookphoto_id, category) 
values (order_seq.NEXTVAL,'RURE1114','2017-3-20','계좌이체', '35000', '2', '포토북');
insert into order_tb (order_id, member_id, order_date, payment, total_price, bookphoto_id, category) 
values (order_seq.NEXTVAL,'RURE1114','2017-3-27','신용카드', '20000', '3', '포토북');

INSERT INTO REVIEW_TB(MEMBER_ID, PRODUCT_ID, CONTENT, IMAGE_ADDRESS, order_ID)
VALUES('RURE1114', '1', '예뻐요 배송빠름', '','1');
INSERT INTO REVIEW_TB(MEMBER_ID, PRODUCT_ID, CONTENT, IMAGE_ADDRESS, ORDER_ID)
VALUES('RURE1114', '2', '별로... 배송빠름', '', '2');
