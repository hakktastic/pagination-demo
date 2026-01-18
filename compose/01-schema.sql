-- generated with AI

-- 01-schema.sql
-- Executed as admin (POSTGRES_USER)

-- 1. Create schema owned by admin
CREATE SCHEMA IF NOT EXISTS pagination_demo_schema
    AUTHORIZATION admin;

CREATE USER app_user PASSWORD 'passw0rd';

-- 2. Ensure objects are created in the correct schema
SET search_path TO pagination_demo_schema;

-- 3. Create sequence
CREATE SEQUENCE IF NOT EXISTS dummy_entity_seq
    START WITH 1
    INCREMENT BY 1
    CACHE 50;

-- 4. Create table
CREATE TABLE IF NOT EXISTS dummy_entity (
    id BIGINT NOT NULL DEFAULT nextval('dummy_entity_seq'),
    dummy_column1 VARCHAR(255),
    dummy_column2 VARCHAR(255),
    dummy_column3 VARCHAR(255),
    dummy_column4 VARCHAR(255),
    dummy_column5 VARCHAR(255),
    CONSTRAINT dummy_entity_pkey PRIMARY KEY (id)
);

-- 5. Bind sequence lifecycle to column
ALTER SEQUENCE dummy_entity_seq
OWNED BY dummy_entity.id;

-- 6. Grant privileges to application user
GRANT USAGE ON SCHEMA pagination_demo_schema TO "app_user";
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE dummy_entity TO "app_user";
GRANT USAGE, SELECT ON SEQUENCE dummy_entity_seq TO "app_user";