DROP TABLE order_tb;
DROP TABLE print_tb;
DROP TABLE photo_tb;
CREATE SEQUENCE order_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE print_seq START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE photo_seq START WITH 1 INCREMENT BY 1;
CREATE TABLE order_tb (
  order_id varchar2(50) NOT NULL,
  member_id varchar2(50),
  order_date Date,
  payment varchar2(50), 
  total_price NUMBER,
  address varchar2(100),
  product_id varchar2(50),
  PRIMARY KEY (order_id)
);

ALTER TABLE order_tb
ADD CONSTRAINT order_tb FOREIGN KEY (member_id)
REFERENCES member_tb (member_id);
insert into order_tb (order_id, member_id, order_date, payment, total_price, address, product_id) 
values (order_seq.NEXTVAL,Lee@Lee.com,'2017-3-20','신용카드', '150000', '서울시 광진구', '2');

CREATE TABLE print_tb (
	print_id varchar2(50) NOT NULL,
	member_id varchar2(50),
	product_id varchar2(50),
	print_option varchar2(50),
	PRIMARY KEY (order_id)
);

ALTER TABLE print_tb
ADD CONSTRAINT print_tb FOREIGN KEY (member_id)
REFERENCES member_tb (member_id);
ALTER TABLE print_tb
ADD CONSTRAINT print_tb FOREIGN KEY (product_id)
REFERENCES product_tb (product_id);

insert into print_tb (print_id, member_id, product_id, print_option) 
values (print_seq.NEXTVAL,Lee@Lee.com, 2,'8*8');

CREATE TABLE photo_tb (
	photo_id varchar2(50) NOT NULL,
	image_address varchar2(100),
	amount NUMBER,
	print_id varchar2(50)
);

ALTER TABLE photo_tb
ADD CONSTRAINT photo_tb FOREIGN KEY (print_id)
REFERENCES print_tb (print_id);

insert into photo_tb (photo_id, image_address, amount, print_id) 
values (photo_seq.NEXTVAL,/images/1.jpg, 1, 1);
insert into photo_tb (photo_id, image_address, amount, print_id) 
values (photo_seq.NEXTVAL,/images/2.jpg, 1, 1);
insert into photo_tb (photo_id, image_address, amount, print_id) 
values (photo_seq.NEXTVAL,/images/3.jpg, 2, 1);
commit;