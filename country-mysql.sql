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
