DROP TABLE IF EXISTS products CASCADE;
CREATE TABLE products (id bigserial PRIMARY KEY, title VARCHAR(255), price int);
INSERT INTO products (title, price) VALUES ('Bread', 35), ('Milk', 60), ('Apples', 135),
('Chocolate', 50), ('Cheese', 150), ('Orange', 170);

DROP TABLE IF EXISTS customers CASCADE;
CREATE TABLE customers (id bigserial PRIMARY KEY, name VARCHAR(255));
INSERT INTO customers (name) VALUES
('John'), ('Michael'), ('Bob');