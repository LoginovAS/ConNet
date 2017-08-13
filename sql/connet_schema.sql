CREATE TABLE IF NOT EXISTS nodes (
  node_id SERIAL,
  node_name VARCHAR(255) NOT NULL,
  region VARCHAR(255),
  street VARCHAR(255),
  building VARCHAR(255),
  PRIMARY KEY (node_id)
) Engine = InnoDB;

CREATE TABLE IF NOT EXISTS connection_units (
  cu_id SERIAL,
  cu_name VARCHAR(255) NOT NULL,
  capacity INTEGER NOT NULL,
  PRIMARY KEY (cu_id)
) Engine = InnoDB;

CREATE TABLE IF NOT EXISTS points (
  point_id SERIAL,
  point_number VARCHAR(50) NOT NULL,
  PRIMARY KEY (point_id)
) Engine = InnoDB;

CREATE TABLE IF NOT EXISTS links (
  link_id SERIAL,
  point_id_1 BIGINT UNSIGNED NOT NULL,
  point_id_2 BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (link_id),
  CONSTRAINT FOREIGN KEY (point_id_1) REFERENCES points(point_id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  CONSTRAINT FOREIGN KEY (point_id_2) REFERENCES points(point_id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
) Engine = InnoDB;

CREATE TABLE IF NOT EXISTS cu_point (
  id SERIAL,
  point_id BIGINT UNSIGNED NOT NULL,
  cu_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT UNIQUE (point_id),
  FOREIGN KEY (point_id) REFERENCES points(point_id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  CONSTRAINT FOREIGN KEY (cu_id) REFERENCES connection_units(cu_id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT
) Engine = InnoDB;

CREATE TABLE IF NOT EXISTS node_cu (
  cu_nodes_id SERIAL,
  node_id BIGINT UNSIGNED NOT NULL,
  cu_id BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (cu_nodes_id),
  FOREIGN KEY (node_id) REFERENCES nodes (node_id)
    ON UPDATE CASCADE
    ON DELETE RESTRICT,
  CONSTRAINT UNIQUE (cu_id),
  FOREIGN KEY (cu_id) REFERENCES connection_units (cu_id)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
) Engine = InnoDB;
