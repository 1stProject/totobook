drop table review_tb cascade constraints;
CREATE TABLE review_tb (
  member_id varchar2(20) NOT NULL,
  product_id varchar2(20) NOT NULL,
  CONTENT varchar2(400) NOT NULL,
  IMAGE_ADDRESS varchar2(20) DEFAULT null,
  order_id varchar2(20),
  CONSTRAINT PK_REVIEW_TB PRIMARY KEY(ORDER_ID)
);
ALTER TABLE review_tb
ADD CONSTRAINT review_tb FOREIGN KEY(ORDER_ID)
REFERENCES ORDER_TB(ORDER_ID);

INSERT INTO REVIEW_TB(MEMBER_ID, PRODUCT_ID, CONTENT, IMAGE_ADDRESS, order_ID)
VALUES('RURE1114', '1', '예뻐요 배송빠름', '','1');
INSERT INTO REVIEW_TB(MEMBER_ID, PRODUCT_ID, CONTENT, IMAGE_ADDRESS, ORDER_ID)
VALUES('RURE1114', '2', '별로... 배송빠름', '', '2');

-- review 사진폴더 /upload/review 

COMMIT;