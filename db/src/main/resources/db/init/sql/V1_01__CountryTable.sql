
CREATE TABLE IF NOT EXISTS country (
    id SERIAL,
    alpha2 char(2) NOT NULL,
    alpha3 char(3) NOT NULL,
    created_on TIMESTAMP NOT NULL DEFAULT NOW(),
    modified_on TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY(id)
);

CREATE UNIQUE INDEX idx_country_alpha2 ON country (alpha2);

CREATE UNIQUE INDEX idx_country_alpha3 ON country (alpha3);