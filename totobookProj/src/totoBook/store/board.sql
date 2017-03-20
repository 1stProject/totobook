DROP TABLE NOTICE_TB;
DROP TABLE QUESTION_TB;
DROP TABLE ANSWER_TB;

DROP SEQUENCE NOTICE_seq;
DROP SEQUENCE question_seq;
DROP SEQUENCE answer_seq;

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
ADD CONSTRAINT QUESTION_TB FOREIGN KEY(MEMBER_ID)
REFERENCES MEMBER_TB(MEMBER_ID);

INSERT INTO QUESTION_TB(post_id, member_id, post_name, content, image_address, image_ext)
VALUES(QUESTION_SEQ.NEXTVAL, 'rure14', '문의드려요.', '배송언제와요?','image/default01.jpg', '.JPG');


CREATE TABLE ANSWER_TB (
  answer_id varchar2(50),
  content varchar2(50) not null,
  post_id varchar2(50) not null,
 PRIMARY KEY (answer_id)
);

ALTER TABLE ANSWER_TB
ADD CONSTRAINT ANSWER_TB FOREIGN KEY(POST_ID)
REFERENCES QUESTION_TB(POST_ID);

INSERT INTO ANSWER_TB(answer_id, content, post_id)
VALUES(ANSWER_SEQ.NEXTVAL, '지금 가고 있습니다.','2');

--SELECT * FROM QUESTION_TB;
--SELECT * FROM ANSWER_TB;
--SELECT * FROM NOTICE_TB;
