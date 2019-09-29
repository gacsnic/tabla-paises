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
COMMIT;
