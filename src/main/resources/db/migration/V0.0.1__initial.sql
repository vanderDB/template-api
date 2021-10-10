CREATE TABLE accounts (
	id BIGINT auto_increment NOT NULL,
	username varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	role varchar(255) NOT NULL,
	enabled BOOL NULL,
	created_on TIMESTAMP NOT NULL,
	updated_on TIMESTAMP NULL,
	CONSTRAINT users_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8
COLLATE=utf8_general_ci;

INSERT INTO accounts (id, username, password, role, enabled, created_on, updated_on)
VALUES
    (1, 'admin@dazg.com', '{noop}adsasdsadsad', 'ROLE_ADMIN', 1, '2019-01-15 15:15:50', '2019-01-15 15:15:50'),
    (2, 'admin2@dazg.com', '{noop}adsasdsadsad', 'ROLE_USER', 1, '2019-01-15 15:15:50', '2019-01-15 15:15:50');