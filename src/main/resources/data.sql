--Address

INSERT INTO address (id, first_line, second_line, postcode, city, country)
VALUES (1, 'first', 'second', 'postcode', 'city', 'country');

INSERT INTO address (id, first_line, second_line, postcode, city, country)
VALUES (2, 'another first', 'another second', 'another postcode', 'another city', 'another country');

--Customer
INSERT INTO customer(id, name, address_id)
VALUES (1, 'Customer one', 1);

INSERT INTO customer(id, name, address_id)
VALUES (2, 'Customer two', 2);

--Invoice
INSERT INTO invoice(id, customer_id)
VALUES (1, 1);

INSERT INTO invoice(id, customer_id)
VALUES (2, 2);

--Invoice Items
INSERT INTO invoice_item(id, description, quantity, price, invoice_id)
VALUES (1, 'This is one item', 1, 123.00, 1);

INSERT INTO invoice_item(id, description, quantity, price, invoice_id)
VALUES (2, 'This is another item', 2, 453.00, 1);

INSERT INTO invoice_item(id, description, quantity, price, invoice_id)
VALUES (3, 'This is a third item', 1, 288.00, 1);

INSERT INTO invoice_item(id, description, quantity, price, invoice_id)
VALUES (4, 'This is fourth item', 1, 111.00, 2);


