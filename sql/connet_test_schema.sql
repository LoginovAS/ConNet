-- Структура: таблицы сущностей --

-- nodes
CREATE TABLE IF NOT EXISTS `nodes` (
  `node_id` SERIAL,
  `node_name` varchar(255) NOT NULL,
  `region` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `building` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- connection_units
CREATE TABLE IF NOT EXISTS `connection_units` (
  `cu_id` SERIAL,
  `cu_name` varchar(255) NOT NULL,
  PRIMARY KEY (`cu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- points
CREATE TABLE IF NOT EXISTS `points` (
  `point_id` SERIAL,
  `point_number` INTEGER NOT NULL,
  PRIMARY KEY (`point_id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- таблица links
CREATE TABLE IF NOT EXISTS `links` (
  `point_id_1` bigint(20) unsigned NOT NULL,
  `point_id_2` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`point_id_1`),
  CONSTRAINT `links_ibfk_1` FOREIGN KEY (`point_id_1`) REFERENCES `points` (`point_id`) ON UPDATE CASCADE,
  CONSTRAINT `links_ibfk_2` FOREIGN KEY (`point_id_2`) REFERENCES `points` (`point_id`) ON UPDATE CASCADE,
  CONSTRAINT UNIQUE (`point_id_1`),
  CONSTRAINT UNIQUE (`point_id_2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Структура: таблицы связей

-- node_cu
CREATE TABLE IF NOT EXISTS `node_cu` (
  `cu_id` bigint(20) unsigned NOT NULL,
  `node_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`cu_id`),
  CONSTRAINT `node_cu_ibfk_1` FOREIGN KEY (`node_id`) REFERENCES `nodes` (`node_id`) ON UPDATE CASCADE,
  CONSTRAINT `node_cu_ibfk_2` FOREIGN KEY (`cu_id`) REFERENCES `connection_units` (`cu_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- cu_point
CREATE TABLE IF NOT EXISTS `cu_point` (
  `point_id` bigint(20) unsigned NOT NULL,
  `cu_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`point_id`),
  CONSTRAINT `cu_point_ibfk_1` FOREIGN KEY (`point_id`) REFERENCES `points` (`point_id`) ON UPDATE CASCADE,
  CONSTRAINT `cu_point_ibfk_2` FOREIGN KEY (`cu_id`) REFERENCES `connection_units` (`cu_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
