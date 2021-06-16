create table queue
(
    id  INT primary key auto_increment,
    msg VARCHAR(50) NOT NULL
);


INSERT INTO queue(msg)
VALUES ('one');
INSERT INTO queue(msg)
VALUES ('two');
INSERT INTO queue(msg)
VALUES ('three');
INSERT INTO queue(msg)
VALUES ('four');
INSERT INTO queue(msg)
VALUES ('five');

