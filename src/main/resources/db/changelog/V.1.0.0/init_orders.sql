-- changeset timin:1
CREATE TABLE orders
(
    id          SERIAL PRIMARY KEY,
    total_price BIGINT,
    user_id     BIGINT    NOT NULL
);
-- rollback drop table orders;