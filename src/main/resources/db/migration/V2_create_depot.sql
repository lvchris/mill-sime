CREATE TABLE depot
(
  id BIGINT PRIMARY KEY,
  farmer_id BIGINT KEY,
  mill VARCHAR(255) NOT NULL,
  order_date DATE NOT NULL,
  delivery_date DATE NOT NULL
);


