CREATE TABLE TB_AUTHOR(
     id integer NOT NULL AUTO_INCREMENT,
     name varchar(100) NOT NULL,
                         PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE TB_BOOK (
  id integer NOT NULL AUTO_INCREMENT,
  title varchar(500) NOT NULL,
  pages integer DEFAULT NULL,
  isbn varchar(50) DEFAULT NULL,
  release_date timestamp DEFAULT NULL,
  author_id integer DEFAULT NULL,
  created_at timestamp DEFAULT NULL,
  laste_modifiet_at timestamp DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (autuor_id) REFERENCES TB_AUTHOR (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;