-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-06-28 10:19:55.777

-- tables
-- Table: cafe_order
CREATE TABLE cafe_order (
                            id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                            created_at timestamp  DEFAULT CURRENT_TIMESTAMP NOT NULL,
                            status     varchar(10) DEFAULT 'OPEN'           NOT NULL,
                            cafe_table_id int  NOT NULL,
                            CONSTRAINT cafe_order_pk PRIMARY KEY (id)
);

-- Table: cafe_table
CREATE TABLE cafe_table (
                            id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                            label varchar(20)  NOT NULL,
                            CONSTRAINT cafe_table_pk PRIMARY KEY (id)
);

-- Table: dish
CREATE TABLE dish (
                      id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                      name varchar(50)  NOT NULL,
                      price decimal(7,2)  NOT NULL,
                      CONSTRAINT dish_pk PRIMARY KEY (id)
);

-- Table: order_item
CREATE TABLE order_item (
                            id int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
                            qty int  NOT NULL,
                            cafe_order_id int  NOT NULL,
                            dish_id int  NOT NULL,
                            CONSTRAINT order_item_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: cafe_order_cafe_table (table: cafe_order)
ALTER TABLE cafe_order ADD CONSTRAINT cafe_order_cafe_table
    FOREIGN KEY (cafe_table_id)
        REFERENCES cafe_table (id);

-- Reference: order_item_cafe_order (table: order_item)
ALTER TABLE order_item ADD CONSTRAINT order_item_cafe_order
    FOREIGN KEY (cafe_order_id)
        REFERENCES cafe_order (id);

-- Reference: order_item_dish (table: order_item)
ALTER TABLE order_item ADD CONSTRAINT order_item_dish
    FOREIGN KEY (dish_id)
        REFERENCES dish (id);

-- End of file.

