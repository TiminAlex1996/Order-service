-- changeset timin:2
CREATE TABLE orders_item
(
    id           SERIAL PRIMARY KEY,
    description  VARCHAR(255) NOT NULL,
    name_product VARCHAR(255) NOT NULL,
    quantity     BIGINT       NOT NULL,
    order_id     BIGINT REFERENCES orders_item (id)
);
-- rollback drop table orders_item;