-- drop schema
DROP SCHEMA IF EXISTS public cascade;

-- create schema
CREATE SCHEMA IF NOT EXISTS public;

-- create table
CREATE TABLE IF NOT EXISTS public.products
(
    id            serial primary key ,
    product_name  varchar,
    product_price varchar
);

CREATE TABLE carts (
    id    serial primary key
);

CREATE TABLE carts_products (
    cart_id integer,
    product_id integer,
    PRIMARY KEY(cart_id, product_id),
    FOREIGN KEY(cart_id) REFERENCES carts(id),
    FOREIGN KEY(product_id) REFERENCES products(id)
);