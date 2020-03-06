CREATE TABLE 商品カテゴリ (
       商品カテゴリID       INTEGER NOT NULL,
       商品カテゴリ名       VARCHAR(100),
       PRIMARY KEY (商品カテゴリID)
);


CREATE TABLE 商品 (
       商品ID               INTEGER NOT NULL,
       商品名               VARCHAR(100),
       金額                 INTEGER,
       税込金額             INTEGER,
       商品区分             INTEGER,
       商品カテゴリID       INTEGER NOT NULL,
       PRIMARY KEY (商品ID), 
       FOREIGN KEY (商品カテゴリID)
                            REFERENCES 商品カテゴリ  (商品カテゴリID)
);


CREATE TABLE 顧客 (
       顧客ID               INTEGER NOT NULL,
       お名前               VARCHAR(100),
       お電話番号           VARCHAR(100),
       PRIMARY KEY (顧客ID)
);


CREATE TABLE 注文 (
       注文ID               INTEGER NOT NULL,
       ご注文数             INTEGER,
       商品ID               INTEGER NOT NULL,
       顧客ID               INTEGER NOT NULL,
       PRIMARY KEY (注文ID), 
       FOREIGN KEY (顧客ID)
                            REFERENCES 顧客  (顧客ID), 
       FOREIGN KEY (商品ID)
                            REFERENCES 商品  (商品ID)
);

--

CREATE TABLE tbl_item_category (
       id       INTEGER NOT NULL,
       name     VARCHAR(100),
       PRIMARY KEY (id)
);

insert into tbl_item_category(id, name) values(1, 'お持ち帰り弁当');
insert into tbl_item_category(id, name) values(2, 'お持ち帰り専用プレート');
insert into tbl_item_category(id, name) values(3, '点心・前菜');
insert into tbl_item_category(id, name) values(4, '一品料理');


CREATE TABLE tbl_item (
       id                INTEGER NOT NULL,
       name              VARCHAR(100),
       price             INTEGER,
       price_tex         INTEGER,
       type              INTEGER,
       category_id       INTEGER NOT NULL,
       PRIMARY KEY (id), 
       FOREIGN KEY (category_id) REFERENCES tbl_item_category(id)
);

insert into tbl_item(id,name,price,price_tex,type,category_id) values(1,'メニュー１',100,110,1,1);
insert into tbl_item(id,name,price,price_tex,type,category_id) values(2,'メニュー２',200,220,1,1);
insert into tbl_item(id,name,price,price_tex,type,category_id) values(3,'メニュー３',300,330,0,2);
insert into tbl_item(id,name,price,price_tex,type,category_id) values(4,'メニュー４',400,440,0,2);
insert into tbl_item(id,name,price,price_tex,type,category_id) values(5,'メニュー５',500,550,0,3);
insert into tbl_item(id,name,price,price_tex,type,category_id) values(6,'メニュー６',600,660,0,3);
insert into tbl_item(id,name,price,price_tex,type,category_id) values(7,'メニュー７',700,770,0,4);
insert into tbl_item(id,name,price,price_tex,type,category_id) values(8,'メニュー８',800,880,0,4);

create sequence seq_customer;

CREATE TABLE tbl_customer (
       id               INTEGER NOT NULL,
       name             VARCHAR(100),
       phone            VARCHAR(100),
       PRIMARY KEY (id)
);

create sequence seq_order;

CREATE TABLE tbl_order (
       id               INTEGER NOT NULL,
       quantity         INTEGER,
       item_id          INTEGER NOT NULL,
       customer_id      INTEGER NOT NULL,
       PRIMARY KEY (id), 
       FOREIGN KEY (customer_id) REFERENCES tbl_customer(id), 
       FOREIGN KEY (item_id)     REFERENCES tbl_item(id)
);


select
  c.id
  , c.name
  , i.name
  , i.price
  , o.quantity 
from
  tbl_customer as c join tbl_order as o 
    on c.id = o.customer_id join tbl_item as i 
    on o.item_id = i.id;