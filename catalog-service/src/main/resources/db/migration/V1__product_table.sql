create sequence product_id_sequence start with 1 increment by 50;

create table products
(
    id          bigint default nextval('product_id_sequence') not null,
    code        text                                          not null,
    name        text                                          not null,
    description text                                          not null,
    image_url   text,
    price       numeric                                       not null,
    primary key (id)
);



SELECT products.code,
       count(*)
FROM products
GROUP BY products.code
HAVING count(*) > 1;

WITH CTE AS (
    SELECT id, ROW_NUMBER() OVER (PARTITION BY code ORDER BY id) AS row_num
    FROM products
)
DELETE FROM products
WHERE id IN (SELECT id FROM CTE WHERE row_num > 1);

ALTER TABLE products ADD CONSTRAINT unique_code UNIQUE (code);


