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
VALUES(option_seq.nextval, '사이즈', 'A3', 2000, 1);