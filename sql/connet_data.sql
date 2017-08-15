-- Nodes --
INSERT INTO nodes (node_name, region, street, building) VALUES ('TestNode2', 'Санкт-Петербург', 'Есенина', '4');
INSERT INTO nodes (node_name, region, street, building) VALUES ('TestNode3', 'Санкт-Петербург', 'Композиторов', '15к1');
INSERT INTO nodes (node_name, region, street, building) VALUES ('TestNode6', 'Москва', 'Мясницкая', '24');
INSERT INTO nodes (node_name, region, street, building) VALUES ('TestNode7', 'Москва', 'Большая Садовая', '10');

-- Connection units --
INSERT INTO connection_units (cu_name) VALUES ('ConnectionUnit1');
INSERT INTO connection_units (cu_name) VALUES ('ConnectionUnit2');
INSERT INTO connection_units (cu_name) VALUES ('ConnectionUnit3');
INSERT INTO connection_units (cu_name) VALUES ('ConnectionUnit4');
INSERT INTO connection_units (cu_name) VALUES ('ConnectionUnit5');
INSERT INTO connection_units (cu_name) VALUES ('ConnectionUnit6');
INSERT INTO connection_units (cu_name) VALUES ('ConnectionUnit7');
INSERT INTO connection_units (cu_name) VALUES ('ConnectionUnit8');

-- node_cu --

INSERT INTO node_cu (cu_id, node_id) VALUES (1, 2);
INSERT INTO node_cu (cu_id, node_id) VALUES (2, 2);
INSERT INTO node_cu (cu_id, node_id) VALUES (3, 2);
INSERT INTO node_cu (cu_id, node_id) VALUES (4, 3);
INSERT INTO node_cu (cu_id, node_id) VALUES (5, 3);
INSERT INTO node_cu (cu_id, node_id) VALUES (6, 4);
INSERT INTO node_cu (cu_id, node_id) VALUES (7, 5);
INSERT INTO node_cu (cu_id, node_id) VALUES (8, 5);

-- points --

INSERT INTO points (point_number) VALUE ('000001');
INSERT INTO points (point_number) VALUE ('000002');
INSERT INTO points (point_number) VALUE ('000003');
INSERT INTO points (point_number) VALUE ('000004');
INSERT INTO points (point_number) VALUE ('000005');
INSERT INTO points (point_number) VALUE ('000006');
INSERT INTO points (point_number) VALUE ('000007');
INSERT INTO points (point_number) VALUE ('000008');
INSERT INTO points (point_number) VALUE ('000009');
INSERT INTO points (point_number) VALUE ('000010');
INSERT INTO points (point_number) VALUE ('000001');
INSERT INTO points (point_number) VALUE ('000002');
INSERT INTO points (point_number) VALUE ('000003');
INSERT INTO points (point_number) VALUE ('000004');
INSERT INTO points (point_number) VALUE ('000005');
INSERT INTO points (point_number) VALUE ('000006');
INSERT INTO points (point_number) VALUE ('000007');
INSERT INTO points (point_number) VALUE ('000008');
INSERT INTO points (point_number) VALUE ('000009');
INSERT INTO points (point_number) VALUE ('000010');
INSERT INTO points (point_number) VALUE ('000001');
INSERT INTO points (point_number) VALUE ('000002');
INSERT INTO points (point_number) VALUE ('000003');
INSERT INTO points (point_number) VALUE ('000004');
INSERT INTO points (point_number) VALUE ('000005');
INSERT INTO points (point_number) VALUE ('000006');
INSERT INTO points (point_number) VALUE ('000007');
INSERT INTO points (point_number) VALUE ('000008');
INSERT INTO points (point_number) VALUE ('000009');
INSERT INTO points (point_number) VALUE ('000010');


-- cu_points --

INSERT INTO cu_points (point_id, cu_id) VALUES (1, 1);
INSERT INTO cu_points (point_id, cu_id) VALUES (2, 1);
INSERT INTO cu_points (point_id, cu_id) VALUES (3, 1);
INSERT INTO cu_points (point_id, cu_id) VALUES (4, 1);
INSERT INTO cu_points (point_id, cu_id) VALUES (5, 1);
INSERT INTO cu_points (point_id, cu_id) VALUES (6, 2);
INSERT INTO cu_points (point_id, cu_id) VALUES (7, 2);
INSERT INTO cu_points (point_id, cu_id) VALUES (8, 2);
INSERT INTO cu_points (point_id, cu_id) VALUES (9, 2);
INSERT INTO cu_points (point_id, cu_id) VALUES (10, 2);
INSERT INTO cu_points (point_id, cu_id) VALUES (12, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (13, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (14, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (15, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (16, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (17, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (18, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (19, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (20, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (21, 3);
INSERT INTO cu_points (point_id, cu_id) VALUES (22, 4);
INSERT INTO cu_points (point_id, cu_id) VALUES (23, 4);
INSERT INTO cu_points (point_id, cu_id) VALUES (24, 4);
INSERT INTO cu_points (point_id, cu_id) VALUES (25, 4);
INSERT INTO cu_points (point_id, cu_id) VALUES (26, 4);
INSERT INTO cu_points (point_id, cu_id) VALUES (27, 5);
INSERT INTO cu_points (point_id, cu_id) VALUES (28, 5);
INSERT INTO cu_points (point_id, cu_id) VALUES (29, 5);
INSERT INTO cu_points (point_id, cu_id) VALUES (30, 5);
INSERT INTO cu_points (point_id, cu_id) VALUES (31, 5);
INSERT INTO cu_points (point_id, cu_id) VALUES (32, 6);
INSERT INTO cu_points (point_id, cu_id) VALUES (33, 6);
INSERT INTO cu_points (point_id, cu_id) VALUES (34, 6);
INSERT INTO cu_points (point_id, cu_id) VALUES (35, 6);
INSERT INTO cu_points (point_id, cu_id) VALUES (36, 6);
INSERT INTO cu_points (point_id, cu_id) VALUES (37, 7);
INSERT INTO cu_points (point_id, cu_id) VALUES (38, 7);
INSERT INTO cu_points (point_id, cu_id) VALUES (39, 8);
INSERT INTO cu_points (point_id, cu_id) VALUES (40, 8);
INSERT INTO cu_points (point_id, cu_id) VALUES (41, 8);