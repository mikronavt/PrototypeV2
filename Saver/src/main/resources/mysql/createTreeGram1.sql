/*
Создание таблиц триграмм 1 вариант
*/
CREATE TABLE IF NOT EXISTS TREEGRAM_RU_VAR_ONE (
	RUID INT(20) NOT NULL auto_increment,
    WORD_ONE VARCHAR(200) NOT NULL,
    WORD_TWO VARCHAR(200) NOT NULL,
    WORD_THREE VARCHAR(200) NOT NULL,
    COUNT INT(20) NOT NULL,
    PRIMARY KEY (RUID)
);

