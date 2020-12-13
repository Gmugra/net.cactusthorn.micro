
CREATE TABLE IF NOT EXISTS customer (
    id SERIAL,
    address_id INTEGER,
    email varchar(100) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT NOW(),
    modified_on TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY(id),
    CONSTRAINT fk_customer_address FOREIGN KEY (address_id) REFERENCES address (id)
);