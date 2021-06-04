CREATE DATABASE IF NOT EXISTS qa_ims;
use qa_ims;

CREATE TABLE Customers(
	customer_id INT NOT NULL AUTO_INCREMENT,
    first_name varchar(20) NOT NULL,
    last_name varchar(20) NOT NULL,
    age INT NOT NULL,
    PRIMARY KEY(customer_id)
);

CREATE TABLE Item(
	item_id INT NOT NULL AUTO_INCREMENT,
    item_name varchar(45) NOT NULL,
    item_value INT NOT NULL,
    PRIMARY KEY(item_id)
);

CREATE TABLE Orders(
	order_id INT NOT NULL AUTO_INCREMENT,
    fk_customer_id INT NOT NULL,
    isComplete BOOL DEFAULT False,
    FOREIGN KEY(fk_customer_id) REFERENCES Customers(customer_id),
    PRIMARY KEY(order_id)
);

CREATE TABLE order_items(
	order_items_id INT NOT NULL AUTO_INCREMENT,
    fk_item_id INT NOT NULL,
    fk_order_id INT NOT NULL,
    FOREIGN KEY(fk_item_id) REFERENCES Item(item_id),
    FOREIGN KEY(fk_order_id) REFERENCES Orders(order_id),
	PRIMARY KEY(order_items_id)
);

SHOW TABLES;


INSERT INTO Customers(first_name, last_name, age) VALUES ('John', 'Mable', 19);
INSERT INTO Customers(first_name, last_name, age) VALUES ('Mark', 'Frezzy', 21);
INSERT INTO Customers(first_name, last_name, age) VALUES ('David', 'Stonks', 65);

INSERT INTO Item(item_name, item_value) VALUES ('Swiffer', 450);
INSERT INTO Item(item_name, item_value) VALUES ('Vaccum 9000', 300);
INSERT INTO Item(item_name, item_value) VALUES ('Bazooka', 1090);

INSERT INTO Orders(fk_customer_id) VALUES(3);
INSERT INTO Orders(fk_customer_id) VALUES(2);

INSERT INTO order_items(fk_customer_id, fk_item_id, fk_order_id) VALUES (3, 1, 1);
INSERT INTO order_items(fk_customer_id, fk_item_id, fk_order_id) VALUES (3, 2, 1);

INSERT INTO order_items(fk_item_id, fk_order_id) VALUES (1, 2);
INSERT INTO order_items(fk_customer_id, fk_item_id, fk_order_id) VALUES (2, 2, 2);

SELECT * FROM customers;
SELECT * FROM item;
SELECT * FROM orders;
SELECT * FROM order_items;
-- ALTER TABLE order_items ADD COLUMN fk_order_id INT NOT NULL;
-- ALTER TABLE order_items ADD COLUMN FOREIGN KEY(fk_order_id) REFERENCES Orders(order_id);

DROP TABLE order_items;
DROP TABLE orders;
DROP TABLE customers;
DROP TABLE item;


/* Customer orders items by id */
SELECT s.customer_id, s.first_name, s.last_name, c.order_id, e.order_items_id, e.fk_item_id, i.item_name, i.item_value
from customers s
    INNER JOIN orders c ON s.customer_id = c.fk_customer_id
    INNER JOIN order_items e ON e.fk_order_id = c.order_id
    INNER JOIN item i ON e.fk_item_id = i.item_id;
    
SELECT s.first_name, s.last_name, o.order_id, o.fk_customer_id, o.isComplete
	from customers s
		INNER JOIN orders o ON s.customer_id = o.fk_customer_id;

DESC orders;

UPDATE Item SET item_name = 'Dog Toy', item_value = 25 WHERE item_id = 4;
