DROP TABLE option_tb;
DROP SEQUENCE option_seq;
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
ADD CONSTRAINT option_tb FOREIGN KEY(product_id)
REFERENCES product_tb(product_id);
INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '반명함', '광택', 5000, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '증명사진', '광택', 3000, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'B4', '광택', 2000, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '15X15', '20', 2000, 2);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '15X13', '40', 2000, 2);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '12X12', '20', 2000, 2);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '12X12', '40', 2000, 2);


