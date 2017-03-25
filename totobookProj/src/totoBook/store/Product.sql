DROP TABLE product_tb;
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
VALUES(PRODUCT_SEQ.NEXTVAL, '결혼식포토북', 20000, 'BOOK', '행복한 결혼을 기록하세요.', '');

INSERT INTO PRODUCT_TB(PRODUCT_ID, PRODUCT_NAME, PRICE, category, DETAIL, IMAGE_ADDRESS)
VALUES(PRODUCT_SEQ.NEXTVAL, '사진인화-반명함', 5000, 'PRINT', '반명함 사진을 인화합니다. 보정가능 짱짱', '');

COMMIT;