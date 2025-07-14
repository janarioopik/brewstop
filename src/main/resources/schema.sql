-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-06-28 10:19:55.777

-- tables
-- Table: cafe_order
CREATE TABLE category (
                          id   INT GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                          name VARCHAR(50) NOT NULL,
                          CONSTRAINT category_pk PRIMARY KEY (id),
                          CONSTRAINT category_name_uq UNIQUE (name)
);

-- ------------------------------------------------------------
-- Table: product
-- ------------------------------------------------------------
CREATE TABLE product (
                         id          INT GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                         name        VARCHAR(100) NOT NULL,
                         price       DECIMAL(7,2) NOT NULL,
                         category_id INT NOT NULL,
                         CONSTRAINT product_pk PRIMARY KEY (id),
                         CONSTRAINT fk_product_category
                             FOREIGN KEY (category_id)
                                 REFERENCES category (id)
);

-- ------------------------------------------------------------
-- Table: price_change
-- ------------------------------------------------------------
CREATE TABLE price_change (
                              id         INT GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                              product_id INT              NOT NULL,
                              old_price  DECIMAL(7,2)     NOT NULL,
                              new_price  DECIMAL(7,2)     NOT NULL,
                              changed_at TIMESTAMP        DEFAULT CURRENT_TIMESTAMP NOT NULL,
                              CONSTRAINT price_change_pk PRIMARY KEY (id),
                              CONSTRAINT fk_price_product
                                  FOREIGN KEY (product_id) REFERENCES product (id)
);


-- End of file.

