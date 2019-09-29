Tabla de países
===============

Este repositorio contiene un pequeño script SQL  con información de países en español.

## Descripción de la tabla
### MYSQL


Field | Type | Null | Key | Default | Extra |
----- | ---- | ---- | --- | ------- | ----- |
id | int(11) unsigned | NO | PRI | NULL | auto_increment |
iso_code | smallint(6) | YES | | NULL | |
| isoa1_code | char(2) | YES | | NULL | |
| isoa2_code | char(3) | YES  | | NULL | |
| Country | varchar(128) | YES  | | NULL | |

## «`Create`» de la tabla

```
CREATE TABLE IF NOT EXIT `Country` (
  `Id` int(11) UNSIGNED NOT NULL auto_increment,
  `iso_code` smallint(6) default NULL,
  `isoa1_code` char(2) default NULL ,
  `isoa2_code` char(3) default NULL ,
  `Country` varchar(128) default NULL,
  PRIMARY KEY  (`Id`),
  INDEX(`isoa1_code`),
  INDEX(`isoa2_code`)
  )  ;
```
### SQLite


Field | Type | Null | Key | Default | Extra |
----- | ---- | ---- | --- | ------- | ----- |
id | INTEGER | NO | PRI | NULL | AUTOINCREMENT |
iso_code | INTEGER | YES | | NULL | |
| isoa1_code | TEXT | YES | | NULL | |
| isoa2_code | TEXT | YES  | | NULL | |
| Country | TEXT | YES  | | NULL | |

## «`Create`» de la tabla

```
BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "Country" (
	"Id"	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	"iso_code"	INTEGER ,
	"isoa1_code"	TEXT,
	"isoa2_code"	TEXT,
	"Country"	TEXT
);
CREATE INDEX IF NOT EXISTS "code_a1" ON "Country" (
	"isoa1_code"
);
CREATE INDEX IF NOT EXISTS "code_a2" ON "Country" (
	"isoa2_code"
);
COMMIT;) 
```

## Descripción de columnas

**iso_code**: ISO 3166-1 numérico, códigos de países de 3 números. Para países que no utilizan el alfabeto latino.
**isoa1_code**: ISO 3166-1 alfa-2, códigos de países de 2 letras. Recomendados para propósito general.
**isoa2_code**: ISO 3166-1 alfa-3, códigos de países de 3 letras. Más relacionado con el nombre del país.

Fuente y mas información: http://es.wikipedia.org/wiki/ISO_3166

