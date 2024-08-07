CREATE DATABASE IF NOT EXISTS `currency_exchange`;
USE `currency_exchange`;

DROP TABLE IF EXISTS `currency`;

CREATE TABLE `currency` (
	-- `currency_id` int NOT NULL AUTO_INCREMENT,
    `code` varchar(3) NOT NULL,
    `name` varchar(255),
    PRIMARY KEY(`code`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `currency_exchange_rate`;

CREATE TABLE `currency_exchange_rate` (
	`curr_exch_rate_id` int NOT NULL AUTO_INCREMENT,
    `from_currency` varchar(3), 
    `to_currency` varchar(3),
    `rate_date` date NOT NULL,
    `exchange_rate` decimal(20,10),
    PRIMARY KEY(`curr_exch_rate_id`),
    FOREIGN KEY (`from_currency`) REFERENCES currency(code),
    FOREIGN KEY (`to_currency`) REFERENCES currency(code)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `request`;

CREATE TABLE request(
	`request_id` varchar(255) NOT NULL,
    `service_id` varchar(30) NOT NULL,
    `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, 
    `end_client_id` varchar(255),
    PRIMARY KEY(`request_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;