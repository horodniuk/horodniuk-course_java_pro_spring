CREATE TABLE orders(
    order_id   serial primary key,
    order_date timestamp,
    cost       decimal
);

CREATE TABLE products(
    product_id serial primary key,
    name       varchar(255),
    price      decimal
);

CREATE TABLE order_product(
    order_id                int,
    product_id              int,
    quantity                int,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) references orders (order_id),
    FOREIGN KEY (product_id) references products (product_id)
);


CREATE TABLE users(
         user_id serial primary key,
         username varchar(128),
         password varchar(128),
         role varchar(128)
);

insert into users (username,  password, role)
    VALUES ('admin','123','ADMIN');


insert into products (name, price)
VALUES ('beer', 50.00),
       ('cola', 30.00),
       ('soap', 20.00);

