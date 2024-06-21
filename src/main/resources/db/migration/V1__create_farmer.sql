CREATE TABLE farmer
(
  id           BIGINT PRIMARY KEY,
  reference    VARCHAR(255) NOT NULL,
  first_name   VARCHAR(255) NOT NULL,
  last_name    VARCHAR(255) NOT NULL,
  email        VARCHAR(255) NOT NULL,
  phone_number VARCHAR(255) NOT NULL

);
ALTER TABLE farmer
  ADD CONSTRAINT farmer_reference_unique UNIQUE (reference);
ALTER TABLE farmer
  ADD CONSTRAINT farmer_email_unique UNIQUE (email);
CREATE SEQUENCE seq_farmer;
