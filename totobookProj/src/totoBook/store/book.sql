DROP TABLE BOOK_TB;

DROP SEQUENCE book_seq;

CREATE SEQUENCE book_seq START WITH 1 INCREMENT BY 1;


CREATE TABLE book_tb (
  book_id varchar2(50),
  book_name varchar2(50) default '포토북 이름',
  member_id varchar2(50) not null,
  save_date date default sysdate,
  book_option varchar2(50),
 PRIMARY KEY (book_id)
);

ALTER TABLE BOOK_TB
ADD CONSTRAINT BOOK_TB FOREIGN KEY(MEMBER_ID)
REFERENCES MEMBER_TB(MEMBER_ID);

INSERT INTO BOOK_TB(BOOK_ID, BOOK_NAME, MEMBER_ID, BOOK_OPTION)
VALUES(BOOK_SEQ.NEXTVAL, '주희의 책', 'RURE1114', '사이즈 : 8*10 , 커버 : 하드 ');

DROP TABLE PAGE_TB;

CREATE SEQUENCE page_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE PAGE_TB (
  PAGE_id varchar2(50),
  book_ID varchar2(50) NOT NULL,
  IMAGE_ADDRESS varchar2(50) not null,
 PRIMARY KEY (PAGE_ID)
);

ALTER TABLE PAGE_TB
ADD CONSTRAINT PAGE_TB FOREIGN KEY(book_ID)
REFERENCES BOOK_TB(book_ID);

INSERT INTO PAGE_TB(PAGE_ID, BOOK_ID, IMAGE_ADDRESS)
VALUES(PAGE_seq.nextval, 2, 'images/defaultpage01.jpg');

commit;