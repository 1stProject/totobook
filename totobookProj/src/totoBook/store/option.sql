DROP TABLE option_tb;

CREATE SEQUENCE option_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE option_tb(
option_id varchar2(20),
option_name varchar2(20),
option_size varchar2(20),
option_price number(10),
product_id varchar2(20)

PRIMARY KEY (option_id));