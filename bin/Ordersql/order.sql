
CREATE TABLE sales (
  sales_code INT NOT NULL,
  total_price INT,
  time DATE,
  PRIMARY KEY (sales_code));


CREATE TABLE menu (
  menu_code INT NOT NULL,
  menu_name VARCHAR(45) NULL,
  menu_price INT NULL,
  PRIMARY KEY (menu_code));


CREATE TABLE burger_order (
  sales_code INT NOT NULL,
  menu_menu_code INT NOT NULL,
  burger_1 INT,
  burger_2 INT,
  burger_3 INT,
  burger_4 INT,
  side_1 INT,
  side_2 INT,
  side_3 INT,
  side_4 INT,
  beverage_1 INT,
  beverage_2 INT,
  beverage_3 INT,
  beverage_4 INT,
  PRIMARY KEY (sales_code));
  
  ALTER TABLE burger_order 
 ADD(CONSTRAINT FK_burger_order FOREIGN KEY(sales_code)
    REFERENCES sales(sales_code));
    
alter table burger_order modify(sales_code int null);

create sequence sales_seq increment by 1 start with 1;

commit;

insert into menu (menu_code, menu_name, menu_price) values(01, '����', 6000);
insert into menu (menu_code, menu_name, menu_price) values(02, 'ġ�����', 6500);
insert into menu (menu_code, menu_name, menu_price) values(03, '����������', 7500);
insert into menu (menu_code, menu_name, menu_price) values(04, '���Ϳ���', 8500);
insert into menu (menu_code, menu_name, menu_price) values(05, '����ġ������', 1500);
insert into menu (menu_code, menu_name, menu_price) values(06, 'ġŲ�ʰ�', 2000);
insert into menu (menu_code, menu_name, menu_price) values(07, 'ġ�ƽ', 1500);
insert into menu (menu_code, menu_name, menu_price) values(08, '�ܻ�����', 1500);
insert into menu (menu_code, menu_name, menu_price) values(09, '�ݶ�', 1500);
insert into menu (menu_code, menu_name, menu_price) values(10, '�����ݶ�', 1500);
insert into menu (menu_code, menu_name, menu_price) values(11, '���̴�', 1500);
insert into menu (menu_code, menu_name, menu_price) values(12, '�������ֽ�', 2000);

alter table burger_order drop column menu_menu_code;

commit;

