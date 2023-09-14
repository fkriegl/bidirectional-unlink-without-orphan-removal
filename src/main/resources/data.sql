CREATE TABLE if not exists parent
(
    id   INTEGER NOT NULL,
    name CHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE if not exists child
(
    id        INTEGER NOT NULL,
    parent_id INTEGER,
    name      CHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (parent_id) REFERENCES parent(id)
);

INSERT INTO parent (id, name)
VALUES (1, 'P1');
INSERT INTO parent (id, name)
VALUES (2, 'P2');

INSERT INTO child (id, parent_id, name)
VALUES (1, 1, 'C1');
INSERT INTO child (id, parent_id, name)
VALUES (2, 1, 'C2');
INSERT INTO child (id, parent_id, name)
VALUES (3, 1, 'C3');
INSERT INTO child (id, parent_id, name)
VALUES (4, 1, 'C4');
INSERT INTO child (id, parent_id, name)
VALUES (5, 1, 'C5');