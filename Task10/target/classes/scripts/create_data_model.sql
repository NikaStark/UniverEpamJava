CREATE TABLE genres
(
  id   SERIAL PRIMARY KEY NOT NULL,
  name VARCHAR(16)
);

CREATE TABLE films
(
  id       SERIAL PRIMARY KEY NOT NULL,
  id_genre BIGINT UNSIGNED,
  name     VARCHAR(64),
  FOREIGN KEY (id_genre) REFERENCES genres (id)
);