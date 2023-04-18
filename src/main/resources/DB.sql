CREATE DATABASE scripts;
USE scripts;
CREATE TABLE scripts
(
    id        int PRIMARY KEY AUTO_INCREMENT,
    author    CHAR(28),
    title     VARCHAR(50),
    rate      int,
    playTimes int
);

INSERT INTO scripts.scripts (author, title, rate, playTimes)
VALUES ('okSpD5JBx8QC1KNP6KUkE5OBYayA', '西北大学·风雨学堂', 5, 2);
INSERT INTO scripts.scripts (author, title, rate, playTimes)
VALUES ('okSpD5JBx8QC1KNP6KUkE5OBYayA', '西北大学·无法忘怀的西迁岁月', 4, 2);
INSERT INTO scripts.scripts (author, title, rate, playTimes)
VALUES ('okSpD5JBx8QC1KNP6KUkE5OBYayA', '西北大学·西北上庠', 4, 1);
INSERT INTO scripts.scripts (author, title, rate, playTimes)
VALUES ('okSpD5JBx8QC1KNP6KUkE5OBYayA', '西北大学·西迁风云', 3, 1);
INSERT INTO scripts.scripts (author, title, rate, playTimes)
VALUES ('okSpD5JBx8QC1KNP6KUkE5OBYayA', '西北大学·西北联大剧本杀', 3, 1);


CREATE TABLE contents
(
    id    int PRIMARY KEY,
    roles TEXT,
    missions TEXT,
    places TEXT,
    FOREIGN KEY (id) REFERENCES scripts (id)
)


