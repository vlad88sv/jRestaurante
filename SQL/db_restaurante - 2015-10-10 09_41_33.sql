-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.16 - MySQL Community Server (GPL)
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para db_restaurante
CREATE DATABASE IF NOT EXISTS `db_restaurante` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `db_restaurante`;


-- Volcando estructura para tabla db_restaurante.res_adicionables
CREATE TABLE IF NOT EXISTS `res_adicionables` (
  `adi_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `adi_adicionable` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `adi_bandera_importante` tinyint(1) unsigned DEFAULT NULL,
  `adi_bandera_agregable` tinyint(1) unsigned DEFAULT '1',
  `adi_bandera_quitable` tinyint(1) unsigned DEFAULT '1',
  `adi_bandera_estadistico` tinyint(1) unsigned DEFAULT NULL,
  `adi_precio` decimal(10,2) unsigned DEFAULT NULL,
  `adi_activo` tinyint(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`adi_id`),
  KEY `adi_activo` (`adi_activo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_adicionables: ~0 rows (aproximadamente)
DELETE FROM `res_adicionables`;
/*!40000 ALTER TABLE `res_adicionables` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_adicionables` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_categoria_productos
CREATE TABLE IF NOT EXISTS `res_categoria_productos` (
  `cap_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cap_categoria_producto` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `cap_nodo_id` int(10) unsigned DEFAULT '0',
  `cap_menu_id` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`cap_id`),
  KEY `FK_nodo_categoria` (`cap_nodo_id`),
  KEY `FK_menu_categoria` (`cap_menu_id`),
  CONSTRAINT `FK_menu_categoria` FOREIGN KEY (`cap_menu_id`) REFERENCES `res_menu` (`men_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_nodo_categoria` FOREIGN KEY (`cap_nodo_id`) REFERENCES `res_nodo` (`nod_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_categoria_productos: ~0 rows (aproximadamente)
DELETE FROM `res_categoria_productos`;
/*!40000 ALTER TABLE `res_categoria_productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_categoria_productos` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_compras
CREATE TABLE IF NOT EXISTS `res_compras` (
  `id_compras` int(10) unsigned NOT NULL,
  `proveedor` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `monto` decimal(10,2) NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `id_empleado` int(10) unsigned NOT NULL,
  `centro_costo` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_compras`),
  KEY `FK_compras_empleados_idx` (`id_empleado`),
  CONSTRAINT `FK_compras_empleados` FOREIGN KEY (`id_empleado`) REFERENCES `res_empleados` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_compras: ~0 rows (aproximadamente)
DELETE FROM `res_compras`;
/*!40000 ALTER TABLE `res_compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_compras` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_corte_z
CREATE TABLE IF NOT EXISTS `res_corte_z` (
  `id_corte_z` int(10) unsigned NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  `id_emp_ingreso` int(10) unsigned NOT NULL,
  `fecha_recibido` datetime NOT NULL,
  `id_emp_recibido` int(10) unsigned NOT NULL,
  `fecha_remesado` datetime NOT NULL,
  `id_emp_remesado` int(10) unsigned NOT NULL,
  `revision_recepcion` int(10) NOT NULL,
  `id_emp_recepcion` int(10) unsigned NOT NULL,
  `total_cuadrar` decimal(10,2) NOT NULL,
  `total_descuentos` decimal(10,2) NOT NULL,
  `total_diferencia` decimal(10,2) NOT NULL,
  `total_efectivo` decimal(10,2) NOT NULL,
  `total_pos` decimal(10,2) NOT NULL,
  `total_compras` decimal(10,2) NOT NULL,
  `total_caja` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id_corte_z`),
  KEY `FK_cortez_emp1_idx` (`id_emp_ingreso`),
  KEY `FK_cortez_emp2_idx` (`id_emp_recibido`),
  KEY `FK_cortez_emp3_idx` (`id_emp_remesado`),
  KEY `FK_cortez_emp4_idx` (`id_emp_recepcion`),
  CONSTRAINT `FK_cortez_emp1` FOREIGN KEY (`id_emp_ingreso`) REFERENCES `res_empleados` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cortez_emp2` FOREIGN KEY (`id_emp_recibido`) REFERENCES `res_empleados` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cortez_emp3` FOREIGN KEY (`id_emp_remesado`) REFERENCES `res_empleados` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cortez_emp4` FOREIGN KEY (`id_emp_recepcion`) REFERENCES `res_empleados` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_corte_z: ~0 rows (aproximadamente)
DELETE FROM `res_corte_z`;
/*!40000 ALTER TABLE `res_corte_z` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_corte_z` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_cuentas
CREATE TABLE IF NOT EXISTS `res_cuentas` (
  `cue_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cue_estado` tinyint(1) unsigned DEFAULT NULL,
  `cue_fecha_creacion` datetime NOT NULL,
  `cue_fecha_cierre` datetime NOT NULL,
  `cue_bandera_exento_iva` datetime NOT NULL,
  `cue_bandera_exento_propina` datetime NOT NULL,
  `cue_mesa` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`cue_id`),
  KEY `cue_estado` (`cue_estado`),
  KEY `cue_fecha_creacion` (`cue_fecha_creacion`),
  KEY `cue_fecha_cierre` (`cue_fecha_cierre`),
  KEY `cue_bandera_exento_iva` (`cue_bandera_exento_iva`),
  KEY `cue_bandera_exento_propina` (`cue_bandera_exento_propina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_cuentas: ~0 rows (aproximadamente)
DELETE FROM `res_cuentas`;
/*!40000 ALTER TABLE `res_cuentas` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_cuentas` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_cuentas_descuento
CREATE TABLE IF NOT EXISTS `res_cuentas_descuento` (
  `id_cuentas_desc` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `id_cuenta` int(10) unsigned NOT NULL,
  `fecha_ingreso` datetime NOT NULL,
  `id_empleado` int(10) unsigned NOT NULL,
  `razon_descuento` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_cuentas_desc`),
  KEY `FK_cue_desc_empleados_idx` (`id_empleado`),
  KEY `FK_cue_desc_cuentas_idx` (`id_cuenta`),
  CONSTRAINT `FK_cue_desc_cuentas` FOREIGN KEY (`id_cuenta`) REFERENCES `res_cuentas` (`cue_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_cue_desc_empleados` FOREIGN KEY (`id_empleado`) REFERENCES `res_empleados` (`emp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_cuentas_descuento: ~0 rows (aproximadamente)
DELETE FROM `res_cuentas_descuento`;
/*!40000 ALTER TABLE `res_cuentas_descuento` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_cuentas_descuento` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_cuentas_ordenes
CREATE TABLE IF NOT EXISTS `res_cuentas_ordenes` (
  `ord_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ord_cuenta_id` int(10) unsigned DEFAULT '0',
  `ord_empleado_id` int(10) unsigned DEFAULT '0',
  `ord_estado_orden` tinyint(1) unsigned DEFAULT '0',
  `ord_fechatiempo_ingreso` datetime DEFAULT NULL,
  PRIMARY KEY (`ord_id`),
  KEY `FK_cuentas_ordenes` (`ord_cuenta_id`),
  KEY `FK_empleado` (`ord_empleado_id`),
  KEY `ord_fechatiempo_ingreso` (`ord_fechatiempo_ingreso`),
  KEY `ord_estado_orden` (`ord_estado_orden`),
  CONSTRAINT `FK_cuentas_ordenes` FOREIGN KEY (`ord_cuenta_id`) REFERENCES `res_cuentas` (`cue_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_empleado` FOREIGN KEY (`ord_empleado_id`) REFERENCES `res_empleados` (`emp_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_cuentas_ordenes: ~0 rows (aproximadamente)
DELETE FROM `res_cuentas_ordenes`;
/*!40000 ALTER TABLE `res_cuentas_ordenes` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_cuentas_ordenes` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_empleados
CREATE TABLE IF NOT EXISTS `res_empleados` (
  `emp_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `emp_usario` varchar(20) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `emp_clave` char(40) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `emp_nombre` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `emp_rol_id` int(5) unsigned DEFAULT '0',
  `emp_activo` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`emp_id`),
  KEY `emp_activo` (`emp_activo`),
  KEY `emp_usario_emp_clave` (`emp_usario`,`emp_clave`),
  KEY `FK_rol_empleado` (`emp_rol_id`),
  CONSTRAINT `FK_rol_empleado` FOREIGN KEY (`emp_rol_id`) REFERENCES `res_roles` (`rol_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_empleados: ~0 rows (aproximadamente)
DELETE FROM `res_empleados`;
/*!40000 ALTER TABLE `res_empleados` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_empleados` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_menu
CREATE TABLE IF NOT EXISTS `res_menu` (
  `men_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `men_menu` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `men_activo` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`men_id`),
  KEY `men_activo` (`men_activo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_menu: ~0 rows (aproximadamente)
DELETE FROM `res_menu`;
/*!40000 ALTER TABLE `res_menu` DISABLE KEYS */;
INSERT INTO `res_menu` (`men_id`, `men_menu`, `men_activo`) VALUES
	(1, 'Ensaladas', 1);
/*!40000 ALTER TABLE `res_menu` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_nodo
CREATE TABLE IF NOT EXISTS `res_nodo` (
  `nod_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nod_nodo` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `nod_activo` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`nod_id`),
  KEY `nod_activo` (`nod_activo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_nodo: ~3 rows (aproximadamente)
DELETE FROM `res_nodo`;
/*!40000 ALTER TABLE `res_nodo` DISABLE KEYS */;
INSERT INTO `res_nodo` (`nod_id`, `nod_nodo`, `nod_activo`) VALUES
	(1, 'oculto', 1),
	(2, 'pastas', 1),
	(3, 'ensaladas', 0);
/*!40000 ALTER TABLE `res_nodo` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_ordenes_productos
CREATE TABLE IF NOT EXISTS `res_ordenes_productos` (
  `orp_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `orp_cuenta_ordenes_id` int(10) unsigned DEFAULT NULL,
  `orp_producto_id` int(10) unsigned DEFAULT NULL,
  `orp_activo` tinyint(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`orp_id`),
  KEY `FK_cuenta_ordenes_producto` (`orp_cuenta_ordenes_id`),
  KEY `FK_productos_ordenes` (`orp_producto_id`),
  KEY `orp_activo` (`orp_activo`),
  CONSTRAINT `FK_cuenta_ordenes_producto` FOREIGN KEY (`orp_cuenta_ordenes_id`) REFERENCES `res_cuentas_ordenes` (`ord_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `FK_productos_ordenes` FOREIGN KEY (`orp_producto_id`) REFERENCES `res_productos` (`pro_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_ordenes_productos: ~0 rows (aproximadamente)
DELETE FROM `res_ordenes_productos`;
/*!40000 ALTER TABLE `res_ordenes_productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_ordenes_productos` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_ordenes_productos_adicionales
CREATE TABLE IF NOT EXISTS `res_ordenes_productos_adicionales` (
  `opa_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `opa_ordenes_producto_id` int(10) unsigned DEFAULT '0',
  `opa_adicional_id` int(10) unsigned DEFAULT '0',
  `opa_operacion` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `opa_activo` tinyint(1) unsigned NOT NULL DEFAULT '0',
  `res_ordenes_productos_adicionales_opa_id` int(10) unsigned NOT NULL,
  PRIMARY KEY (`opa_id`),
  KEY `FK_res_ordenes_productos_adicionales_res_adicionables` (`opa_adicional_id`),
  KEY `opa_activo` (`opa_activo`),
  KEY `opa_operacion` (`opa_operacion`),
  KEY `fk_res_ordenes_productos_adicionales_res_ordenes_productos_ad1` (`opa_ordenes_producto_id`),
  CONSTRAINT `FK_res_ordenes_productos_adicionales_res_adicionables` FOREIGN KEY (`opa_adicional_id`) REFERENCES `res_adicionables` (`adi_id`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `fk_res_ordenes_productos_adicionales_res_ordenes_productos_ad1` FOREIGN KEY (`opa_ordenes_producto_id`) REFERENCES `res_ordenes_productos` (`orp_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_ordenes_productos_adicionales: ~0 rows (aproximadamente)
DELETE FROM `res_ordenes_productos_adicionales`;
/*!40000 ALTER TABLE `res_ordenes_productos_adicionales` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_ordenes_productos_adicionales` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_productos
CREATE TABLE IF NOT EXISTS `res_productos` (
  `pro_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `pro_producto` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pro_producto_categoria_id` int(10) unsigned DEFAULT NULL,
  `pro_precio` decimal(10,2) DEFAULT NULL,
  `pro_activo` tinyint(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`pro_id`),
  KEY `pro_activo` (`pro_activo`),
  KEY `FK_categoria_producto` (`pro_producto_categoria_id`),
  CONSTRAINT `FK_categoria_producto` FOREIGN KEY (`pro_producto_categoria_id`) REFERENCES `res_categoria_productos` (`cap_id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_productos: ~2 rows (aproximadamente)
DELETE FROM `res_productos`;
/*!40000 ALTER TABLE `res_productos` DISABLE KEYS */;
INSERT INTO `res_productos` (`pro_id`, `pro_producto`, `pro_producto_categoria_id`, `pro_precio`, `pro_activo`) VALUES
	(1, 'Algo', NULL, NULL, NULL),
	(2, 'Producto 2', NULL, 10.00, NULL);
/*!40000 ALTER TABLE `res_productos` ENABLE KEYS */;


-- Volcando estructura para tabla db_restaurante.res_roles
CREATE TABLE IF NOT EXISTS `res_roles` (
  `rol_id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `rol_rol` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`rol_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Volcando datos para la tabla db_restaurante.res_roles: ~0 rows (aproximadamente)
DELETE FROM `res_roles`;
/*!40000 ALTER TABLE `res_roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `res_roles` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
