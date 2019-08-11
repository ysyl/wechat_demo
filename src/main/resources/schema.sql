use mydb;

DROP table IF EXISTS t_note;

CREATE TABLE t_note (
  id INT NOT NULL auto_increment,
  title VARCHAR(50) not null,
  description varchar(255) default "",
  cost double not null,
  create_time datetime not null,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;