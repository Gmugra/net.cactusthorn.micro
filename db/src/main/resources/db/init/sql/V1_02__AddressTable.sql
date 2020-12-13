CREATE TABLE IF NOT EXISTS address (
    id SERIAL,
    country_id INTEGER NOT NULL,
    addres1 VARCHAR(100) NOT NULL,
    addres2 VARCHAR(100),
    city VARCHAR(100) NOT NULL,
    zip VARCHAR(10) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT NOW(),
    modified_on TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY(id),
    CONSTRAINT fk_address_country FOREIGN KEY (country_id) REFERENCES country (id)
);