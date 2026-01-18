-- generated with AI

-- 02-data.sql
-- Runs once during container initialization

SET search_path TO pagination_demo_schema;

COPY dummy_entity (
    dummy_column1,
    dummy_column2,
    dummy_column3,
    dummy_column4,
    dummy_column5
)
FROM '/docker-entrypoint-initdb.d/dummy_entity.csv'
WITH (
    FORMAT csv,
    DELIMITER ',',
    HEADER false
);