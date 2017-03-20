DROP TABLE product_tb;

CREATE SEQUENCE product_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE product_tb(
product_id varchar2(20),
product_name varchar2(20),
IMG_CONT_TYPE varchar2(20),
IMG_FILE_NAME varchar2(20),
product_price number(10),
product_category varchar2(30),
product_descript varchar2(400),
PRIMARY KEY (product_id));