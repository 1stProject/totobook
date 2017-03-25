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

commit;