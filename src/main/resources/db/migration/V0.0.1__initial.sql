CREATE TABLE template_api.users (
	id BIGINT auto_increment NOT NULL,
	username varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	enabled BOOL NULL,
	created_on INT NOT NULL,
	updated_on INT NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;
