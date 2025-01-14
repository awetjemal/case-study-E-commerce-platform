ALTER TABLE orders
    DROP FOREIGN KEY customer_id;

ALTER TABLE favorite
    DROP FOREIGN KEY customer_id_fav;

ALTER TABLE `history`
    DROP FOREIGN KEY customer_id_history;

ALTER TABLE reviews
    DROP FOREIGN KEY customer_id_review;

ALTER TABLE orderdetails
    DROP FOREIGN KEY order_id;

ALTER TABLE orderdetails
    DROP FOREIGN KEY product_id;

ALTER TABLE favorite
    DROP FOREIGN KEY product_id_fav;

ALTER TABLE `history`
    DROP FOREIGN KEY product_id_history;

ALTER TABLE reviews
    DROP FOREIGN KEY product_id_review;

ALTER TABLE products
    ADD image_url VARCHAR(255) NULL;

ALTER TABLE products
    ADD key_words VARCHAR(255) NULL;

ALTER TABLE products
    ADD price DECIMAL NULL;

DROP TABLE customers;

DROP TABLE favorite;

DROP TABLE `history`;

DROP TABLE orderdetails;

DROP TABLE orders;

DROP TABLE reviews;

ALTER TABLE products
    DROP COLUMN category;

ALTER TABLE products
    DROP COLUMN `description`;

ALTER TABLE products
    DROP COLUMN image;

ALTER TABLE products
    MODIFY name VARCHAR(255);

ALTER TABLE products
    MODIFY name VARCHAR(255) NULL;