DROP SCHEMA IF EXISTS auth CASCADE;
CREATE SCHEMA auth;

DO '
BEGIN
execute ''alter database ''||current_database()||'' set search_path to auth,public;'';
END;
';

SET search_path to auth,public;

SET default_tablespace = '';

SET default_with_oids = false;
  
CREATE TABLE auth."ROLES" (
    id bigint NOT NULL,
    "NAME" text
);

ALTER TABLE auth."ROLES" OWNER TO postgres;

CREATE TABLE auth."USERS" (
    id bigint NOT NULL,
    username text,
    name text,
    role bigint,
    password text
);

ALTER TABLE auth."USERS" OWNER TO postgres;

ALTER TABLE ONLY auth."ROLES"
    ADD CONSTRAINT "USER_ROLES_pkey" PRIMARY KEY (id);

ALTER TABLE ONLY auth."USERS"
    ADD CONSTRAINT pk PRIMARY KEY (id);

ALTER TABLE ONLY auth."USERS"
    ADD CONSTRAINT rolefk FOREIGN KEY (role) REFERENCES auth."ROLES"(id);

INSERT INTO auth."ROLES" (id, "NAME") VALUES (1, 'ADMIN');
INSERT INTO auth."ROLES" (id, "NAME") VALUES (2, 'GUEST');

INSERT INTO auth."USERS" (id, username, name, role, password) VALUES (1, 'admin@auth.it', 'Administrator', 1, '$2a$10$VB7y/I.oD16QBVaExgH1K.VEuBUKRyXcCUVweUGhs1vDl0waTQPmC');
INSERT INTO auth."USERS" (id, username, name, role, password) VALUES (2, 'user@auth.it', 'User', 2, '$2a$10$yK1pW21E8nlZd/YcOt6uB.n8l36a33RP3/hehbWFAcBsFJhVKlZ82');
