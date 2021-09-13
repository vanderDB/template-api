SET DATABASE SQL SYNTAX ORA TRUE

CREATE TABLE users (
	id BIGINT NOT NULL,
	username varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	enabled BOOLEAN NULL,
	created_on TIMESTAMP NOT NULL,
	updated_on TIMESTAMP NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
);