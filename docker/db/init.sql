CREATE DATABASE IF NOT EXISTS plantree;

USE plantree;

CREATE TABLE IF NOT EXISTS tree (
    id BIGINT NOT NULL,
    name VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO tree (id, name) VALUES (1, "First");
INSERT INTO tree (id, name) VALUES (2, "Second");
