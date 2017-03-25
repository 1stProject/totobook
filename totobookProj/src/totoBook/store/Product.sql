DROP TABLE product_tb CASCADE CONSTRAINT;
DROP SEQUENCE product_seq;
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
VALUES(PRODUCT_SEQ.NEXTVAL, '사진인화', 5000, 'PRINT', '항상 어디에서도 빛나는 사진들입니다', '');

INSERT INTO PRODUCT_TB(PRODUCT_ID, PRODUCT_NAME, PRICE, category, DETAIL, IMAGE_ADDRESS)
VALUES(PRODUCT_SEQ.NEXTVAL, '결혼식포토북', 20000, 'BOOK', '행복한 결혼을 기록하세요.', '');

COMMIT;

-- upload파일경로 /upload/product

