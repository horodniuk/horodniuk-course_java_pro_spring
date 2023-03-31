CREATE TABLE orders(
    order_id   bigserial primary key,
    order_date timestamp,
    cost       numeric(19, 2)
);

CREATE TABLE products(
    product_id bigserial primary key,
    name       varchar(255),
    price      numeric(19, 2),
    order_id   bigint,
    foreign key (order_id) references orders (order_id) on delete cascade on update cascade
);