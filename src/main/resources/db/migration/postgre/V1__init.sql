-- Create sequence
CREATE SEQUENCE test_schema.users_user_id_seq
    INCREMENT 1
    START 3
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE test_schema.users_user_id_seq
    OWNER TO postgres;

GRANT ALL ON SEQUENCE test_schema.users_user_id_seq TO karim;

GRANT ALL ON SEQUENCE test_schema.users_user_id_seq TO postgres;

--Create table

CREATE TABLE test_schema.users
(
    user_id integer NOT NULL DEFAULT nextval('test_schema.users_user_id_seq'::regclass),
    name text COLLATE pg_catalog."default",
    CONSTRAINT users_pkey PRIMARY KEY (user_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE test_schema.users
    OWNER to postgres;

GRANT ALL ON TABLE test_schema.users TO karim;

GRANT ALL ON TABLE test_schema.users TO postgres;

--Create sequence
CREATE SEQUENCE test_schema.contact_contact_id_seq
    INCREMENT 1
    START 8
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE test_schema.contact_contact_id_seq
    OWNER TO postgres;

GRANT ALL ON SEQUENCE test_schema.contact_contact_id_seq TO karim;

GRANT ALL ON SEQUENCE test_schema.contact_contact_id_seq TO postgres;


-- Table: test_schema.contact

-- DROP TABLE test_schema.contact;

CREATE TABLE test_schema.contact
(
    contact_id integer NOT NULL DEFAULT nextval('test_schema.contact_contact_id_seq'::regclass),
    "number" text COLLATE pg_catalog."default",
    name text COLLATE pg_catalog."default",
    user_id integer,
    CONSTRAINT contact_pkey PRIMARY KEY (contact_id),
    CONSTRAINT contact_user_fkey FOREIGN KEY (user_id)
        REFERENCES test_schema.users (user_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE test_schema.contact
    OWNER to postgres;

GRANT ALL ON TABLE test_schema.contact TO karim;

GRANT ALL ON TABLE test_schema.contact TO postgres;

