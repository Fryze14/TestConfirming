CREATE SCHEMA `test_ibm`;

CREATE TABLE PROVEEDORES (id_proveedor INT, nombre VARCHAR(50), fecha_de_alta DATE, id_cliente INT);

ALTER TABLE PROVEEDORES ADD PRIMARY KEY (id_proveedor);

INSERT INTO proveedores VALUES (1, "Coca-cola", STR_TO_DATE('01-01-2012', '%d-%m-%Y'), 5);
INSERT INTO proveedores VALUES (2, "Pepsi", STR_TO_DATE('06-11-2016', '%d-%m-%Y'), 5);
INSERT INTO proveedores VALUES (3, "Redbull", STR_TO_DATE('16-09-2020', '%d-%m-%Y'), 6);