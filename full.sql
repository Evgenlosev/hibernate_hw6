DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO products (title, price) VALUES ('Bread', 35), ('Milk', 60), ('Apples', 135),
('Chocolate', 50), ('Cheese', 150), ('Orange', 170);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('John'), ('Michael'), ('Bob');

DROP TABLE IF EXISTS products_customers CASCADE;
CREATE TABLE products_customers (product_id bigint, customer_id bigint, FOREIGN KEY (product_id) REFERENCES products (id), FOREIGN KEY (customer_id) REFERENCES customers (id));
INSERT INTO products_customers (product_id, customer_id) VALUES
(1, 1),
(2, 1),
(3, 1),
(1, 2),
(4, 2),
(6, 2),
(4, 3),
(5, 3),
(6, 3);