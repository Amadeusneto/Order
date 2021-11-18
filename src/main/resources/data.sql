insert into product  (id) values (1,);
insert into product  (id) values (2,);
insert into product  (id) values (3,);
insert into product  (id) values (4,);
insert into product  (id) values (5,);
insert into product  (id) values (6,);
insert into product  (id) values (7,);
insert into product  (id) values (8,);
insert into product  (id) values (9,);
insert into product  (id) values (10,);


insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (1,STR_TO_DATE('2021-11-08','%Y-%m-%d'),'Product 1',10,1,1,10.50);
insert into order_product (id, product_code,order_code) values (1,1,1);
insert into order_product (id, product_code,order_code) values (2,2,1);

insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (2,STR_TO_DATE('2021-11-09','%Y-%m-%d'),'Product 2',10,2,1,50);
insert into order_product (id, product_code,order_code) values (3,3,2);
insert into order_product (id, product_code,order_code) values (4,4,2);

insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (3,STR_TO_DATE('2021-11-10','%Y-%m-%d'),'Product 3',10,3,1,103.80);
insert into order_product (id, product_code,order_code) values (5,5,3);
insert into order_product (id, product_code,order_code) values (6,6,3);

insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (4,STR_TO_DATE('2021-11-11','%Y-%m-%d'),'Product 4',10,4,1,294.50);
insert into order_product (id, product_code,order_code) values (7,5,4);
insert into order_product (id, product_code,order_code) values (8,6,4);

insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (5,STR_TO_DATE('2021-11-12','%Y-%m-%d'),'Product 5',10,5,1,355.50);
insert into order_product (id, product_code,order_code) values (9,5,5);
insert into order_product (id, product_code,order_code) values (10,6,5);

insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (6,STR_TO_DATE('2021-11-13','%Y-%m-%d'),'Product 6',10,6,1,381);
insert into order_product (id, product_code,order_code) values (11,5,6);
insert into order_product (id, product_code,order_code) values (12,6,6);

insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (7,STR_TO_DATE('2021-11-14','%Y-%m-%d'),'Product 7',10,7,1,423);
insert into order_product (id, product_code,order_code) values (13,5,7);
insert into order_product (id, product_code,order_code) values (14,6,7);

insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (8,STR_TO_DATE('2021-11-15','%Y-%m-%d'),'Product 8',10,8,1,80);
insert into order_product (id, product_code,order_code) values (15,5,8);
insert into order_product (id, product_code,order_code) values (16,6,8);

insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (9,STR_TO_DATE('2021-11-16','%Y-%m-%d'),'Product 9',10,9,1,190);
insert into order_product (id, product_code,order_code) values (17,5,9);
insert into order_product (id, product_code,order_code) values (18,6,9);

insert into order (order_code,registration_date,name,value,quantity,client_code,total) values (10,STR_TO_DATE('2021-11-17','%Y-%m-%d'),'Product 10',10,10,1,256.50);
insert into order_product (id, product_code,order_code) values (19,5,10);
insert into order_product (id, product_code,order_code) values (20,6,10);