create sequence product_id_sequence start with 1 increment by 50;

create table products
(
    id bigint default nextval('product_id_sequence') not null,
    code text not null,
    name text not null,
    description text not null,
    image_url text,
    price numeric not null,
    primary key (id)
);

select * from products;

