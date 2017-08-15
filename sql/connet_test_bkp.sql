-- Структура: таблицы сущностей --

-- nodes
CREATE TABLE IF NOT EXISTS `nodes` (
  `node_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `node_name` varchar(255) NOT NULL,
  `region` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `building` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`node_id`),
  UNIQUE KEY `node_id` (`node_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- connection_units
CREATE TABLE IF NOT EXISTS `connection_units` (
  `cu_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cu_name` varchar(255) NOT NULL,
  PRIMARY KEY (`cu_id`),
  UNIQUE KEY `cu_id` (`cu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- points
CREATE TABLE IF NOT EXISTS `points` (
  `point_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `point_number` varchar(50) NOT NULL,
  PRIMARY KEY (`point_id`),
  UNIQUE KEY `point_id` (`point_id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

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
  KEY `node_id` (`node_id`),
  CONSTRAINT `node_cu_ibfk_1` FOREIGN KEY (`node_id`) REFERENCES `nodes` (`node_id`) ON UPDATE CASCADE,
  CONSTRAINT `node_cu_ibfk_2` FOREIGN KEY (`cu_id`) REFERENCES `connection_units` (`cu_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- cu_point
CREATE TABLE IF NOT EXISTS `cu_point` (
  `point_id` bigint(20) unsigned NOT NULL,
  `cu_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`point_id`),
  KEY `cu_id` (`cu_id`),
  CONSTRAINT `cu_point_ibfk_1` FOREIGN KEY (`point_id`) REFERENCES `points` (`point_id`) ON UPDATE CASCADE,
  CONSTRAINT `cu_point_ibfk_2` FOREIGN KEY (`cu_id`) REFERENCES `connection_units` (`cu_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Данные основных таблиц

-- nodes
ALTER TABLE `nodes` DISABLE KEYS;
INSERT INTO `nodes` (`node_id`, `node_name`, `region`, `street`, `building`) VALUES
	(2, 'TestNode1', 'Санкт-Петербург', 'Невский проспект', '11 лит А'),
	(3, 'TestNode2', 'Санкт-Петербург', 'Есенина', '4'),
	(4, 'TestNode3', 'Санкт-Петербург', 'Композиторов', '15к1'),
	(5, 'TestNode4', 'Москва', 'Кожевническая', '7/1');
ALTER TABLE `nodes` ENABLE KEYS;

-- connection_units
ALTER TABLE `connection_units` DISABLE KEYS;
INSERT INTO `connection_units` (`cu_id`, `cu_name`) VALUES
	(1, 'ConnectionUnit1'),
	(2, 'ConnectionUnit2'),
	(3, 'ConnectionUnit3'),
	(4, 'ConnectionUnit4'),
	(5, 'ConnectionUnit5'),
	(6, 'ConnectionUnit6'),
	(7, 'ConnectionUnit7'),
	(8, 'ConnectionUnit8');
ALTER TABLE `connection_units` ENABLE KEYS;

-- points
ALTER TABLE `points` DISABLE KEYS;
INSERT INTO `points` (`point_id`, `point_number`) VALUES
	(1, '000001'),
	(2, '000002'),
	(3, '000003'),
	(4, '000004'),
	(5, '000005'),
	(6, '000006'),
	(7, '000007'),
	(8, '000008'),
	(9, '000009'),
	(10, '000010'),
	(12, '000001'),
	(13, '000002'),
	(14, '000003'),
	(15, '000004'),
	(16, '000005'),
	(17, '000006'),
	(18, '000007'),
	(19, '000008'),
	(20, '000009'),
	(21, '000010'),
	(22, '000001'),
	(23, '000002'),
	(24, '000003'),
	(25, '000004'),
	(26, '000005'),
	(27, '000006'),
	(28, '000007'),
	(29, '000008'),
	(30, '000009'),
	(31, '000010'),
	(32, '000001'),
	(33, '000002'),
	(34, '000003'),
	(35, '000004'),
	(36, '000005'),
	(37, '000006'),
	(38, '000007'),
	(39, '000008'),
	(40, '000009'),
	(41, '000010');
ALTER TABLE `points` ENABLE KEYS;

-- links
/* ALTER TABLE `links` DISABLE KEYS */;
/* ALTER TABLE `links` ENABLE KEYS */;

-- Данные линковочных таблиц

-- node_cu
ALTER TABLE `node_cu` DISABLE KEYS;
INSERT INTO `node_cu` (`cu_id`, `node_id`) VALUES
	(1, 2),
	(2, 2),
	(3, 2),
	(4, 3),
	(5, 3),
	(6, 4),
	(7, 5),
	(8, 5);
ALTER TABLE `node_cu` ENABLE KEYS;

-- cu_point
ALTER TABLE `cu_point` DISABLE KEYS;
INSERT INTO `cu_point` (`point_id`, `cu_id`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(4, 1),
	(5, 1),
	(6, 2),
	(7, 2),
	(8, 2),
	(9, 2),
	(10, 2),
	(12, 3),
	(13, 3),
	(14, 3),
	(15, 3),
	(16, 3),
	(17, 3),
	(18, 3),
	(19, 3),
	(20, 3),
	(21, 3),
	(22, 4),
	(23, 4),
	(24, 4),
	(25, 4),
	(26, 4),
	(27, 5),
	(28, 5),
	(29, 5),
	(30, 5),
	(31, 5),
	(32, 6),
	(33, 6),
	(34, 6),
	(35, 6),
	(36, 6),
	(37, 7),
	(38, 7),
	(39, 8),
	(40, 8),
	(41, 8);
ALTER TABLE `cu_point` ENABLE KEYS;