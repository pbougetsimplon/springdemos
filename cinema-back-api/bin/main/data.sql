DROP TABLE IF EXISTS movieold^;

CREATE TABLE movieold (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `duration` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8^;

insert into movieold (id,name, duration) values (1, "Covid-19",156)^;

DROP TRIGGER IF EXISTS test_delete_movie^;

CREATE TRIGGER test_delete_movie
BEFORE DELETE ON movie
FOR EACH ROW BEGIN
	 INSERT INTO movieold(id, name, duration)
	 VALUE (OLD.id, OLD.name, OLD.duration);
END^;