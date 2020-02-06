CREATE TABLE TB_BOOK (
  id integer NOT NULL AUTO_INCREMENT,
  `user` varchar(500) NOT NULL,
  password integer DEFAULT NULL,
  created_at timestamp DEFAULT NULL,
  laste_modifiet_at timestamp DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;