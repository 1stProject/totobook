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
VALUES(option_seq.nextval, '지갑용', '8.3cm X 5.2cm', 500, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '정사각(4X4)', '10.2cm X 10.2cm', 110, 1);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, '4X6', '10.2cm X 15.1cm', 140, 1);


INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'Q88정사각형(21X21cm)', '40', 2000, 2);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'Q88정사각형(21X21cm)', '40', 6000, 2);


INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4세로형(21cmX30cm)', '40', 2500, 2);

INSERT INTO option_tb(option_id, option_name, value, option_price, product_id)
VALUES(option_seq.nextval, 'A4세로형(21cmX30cm)', '40', 4000, 2);

commit;

-- review 업로드 파일 /upload/review/