CREATE TABLE `customerbookings` (
  `flight_date` date NOT NULL,
  `first_name` char(20) NOT NULL,
  `middle_name` char(20) NOT NULL,
  `last_name` char(20) NOT NULL,
  `phone` char(20) DEFAULT NULL,
  `email` char(20) DEFAULT NULL,
  `origin` char(20) DEFAULT NULL,
  `destination` char(20) DEFAULT NULL,
  `age` int NOT NULL,
  `sex` char(10) DEFAULT NULL,
  `street` char(20) NOT NULL,
  `city` char(20) NOT NULL,
  `state` char(20) NOT NULL,
  `country` char(20) NOT NULL,
  `zipcode` char(20) DEFAULT NULL,
  `flight` char(20) DEFAULT NULL,
  `fare` float(6,2) NOT NULL,
  `book_number` char(20) NOT NULL,
  PRIMARY KEY (`flight_date`,`book_number`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii