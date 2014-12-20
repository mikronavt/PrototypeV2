/*Создание таблицы IDF для англоязычных слов*/
CREATE TABLE IF NOT EXISTS IDF_EN(
    ENID INT(20) NOT NULL,
    IDF FLOAT(20) NOT NULL,
    PRIMARY_KEY (ENID),
    CONSTRAINT FOREIGN KEY (ENID) REFERENCES DICTIONARY_EN (ENID) ON DELETE CASCADE ON UPDATE CASCADE
);