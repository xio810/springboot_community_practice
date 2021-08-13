drop database if exists demo1;
create database demo1;
use demo1;
show tables;

CREATE TABLE article (
    id INT(10) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
    regDate DATETIME NOT NULL,
    updateDate DATETIME NOT NULL,
    title CHAR(100) NOT NULL,
	`body` TEXT NOT NULL
);

insert into article
set regdate = now(),
updateDate = now(),
title = '제목1',
body = '내용1';

insert into article
set regdate = now(),
updateDate = now(),
title = '제목2',
body = '내용2';

insert into article
set regdate = now(),
updateDate = now(),
title = '제목3',
body = '내용3';

select * from article;
