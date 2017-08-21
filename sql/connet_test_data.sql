-- Данные основных таблиц

-- nodes
INSERT INTO `nodes` (`node_id`, `node_name`, `region`, `street`, `building`) VALUES
	(2, 'TestNode1', 'Санкт-Петербург', 'Невский проспект', '11 лит А'),
	(3, 'TestNode2', 'Санкт-Петербург', 'Есенина', '4'),
	(4, 'TestNode3', 'Санкт-Петербург', 'Композиторов', '15к1'),
	(5, 'TestNode4', 'Москва', 'Кожевническая', '7/1'),
	(6, 'TestNode5', 'Москва', 'Большая Садовая', '10');

-- connection_units
INSERT INTO `connection_units` (`cu_id`, `cu_name`) VALUES
	(1, 'ConnectionUnit1'),
	(2, 'ConnectionUnit2'),
	(3, 'ConnectionUnit3'),
	(4, 'ConnectionUnit4'),
	(5, 'ConnectionUnit5'),
	(6, 'ConnectionUnit6'),
	(7, 'ConnectionUnit7'),
	(8, 'ConnectionUnit8'),
	(9, 'ConnectionUnit9' );

-- points
INSERT INTO `points` (`point_id`, `point_number`) VALUES
	(1, 1),
	(2, 2),
	(3, 3),
	(4, 4),
	(5, 5),
	(6, 1),
	(7, 2),
	(8, 3),
	(9, 4),
	(10, 5),
	(12, 1),
	(13, 2),
	(14, 3),
	(15, 4),
	(16, 5),
	(17, 6),
	(18, 7),
	(19, 8),
	(20, 9),
	(21, 10),
	(22, 1),
	(23, 2),
	(24, 3),
	(25, 4),
	(26, 5),
	(27, 1),
	(28, 2),
	(29, 3),
	(30, 4),
	(31, 5),
	(32, 1),
	(33, 2),
	(34, 3),
	(35, 4),
	(36, 5),
	(37, 1),
	(38, 2),
	(39, 1),
	(40, 2),
	(41, 3),
	(42, 1),
	(43, 2),
	(44, 3),
	(45, 4);

-- Данные линковочных таблиц

-- links
-- Реализует связь 'Один к одному' для двух точек.
INSERT INTO `links` (`point_id_1`, `point_id_2`) VALUES
        (1, 22),
        (2, 37),
        (3, 39),
        (4, 23),
        (5, 33),
        (32, 6),
        (34, 27),
        (35, 31),
        (36, 38);

-- node_cu
-- Реализует связь 'один ко многим' для Коннекторов и Хостов
INSERT INTO `node_cu` (`cu_id`, `node_id`) VALUES
	(1, 2),
	(2, 2),
	(3, 2),
	(4, 3),
	(5, 3),
	(6, 4),
	(7, 5),
	(8, 5),
	(9, 6);

-- cu_point
-- Реализует связь 'один ко многим' для Точек и Коннекторов
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
	(41, 8),
	(42, 9),
	(43, 9),
	(44, 9),
	(45, 9);

COMMIT;

-- контрольный замер
--S ELECT COUNT(*) FROM `nodes`;
SELECT COUNT(*) FROM `nodes`; -- Result: 5;
-- SELECT COUNT(*) FROM `connection_units`;
SELECT COUNT(*) FROM `connection_units`; -- Result: 9;
-- SELECT COUNT(*) FROM `points`;
SELECT COUNT(*) FROM `points`; -- Result: 44;
-- SELECT COUNT(*) FROM `links`;
SELECT COUNT(*) FROM `links`; -- Result: 9;
-- SELECT COUNT(*) FROM `node_cu`;
SELECT COUNT(*) FROM `node_cu`; -- Result: 9;
-- SELECT COUNT(*) FROM `cu_point`;
SELECT COUNT(*) FROM `cu_point`; -- Result: 44;
