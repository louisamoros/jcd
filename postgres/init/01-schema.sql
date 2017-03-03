DROP SCHEMA IF EXISTS jcd_recruiting CASCADE;
CREATE SCHEMA IF NOT EXISTS jcd_recruiting;
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS unaccent;
-- Make the schema 'jcd_recruiting' default
ALTER DATABASE postgres SET search_path TO jcd_recruiting, public;
SET search_path TO jcd_recruiting, public;

-- Language table
CREATE TABLE jcd_recruiting.language (
  name        VARCHAR(50) NOT NULL PRIMARY KEY,
  description VARCHAR(50)
);

-- Developer table
CREATE TABLE jcd_recruiting.developper (
  id         UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
  last_name  VARCHAR(50),
  first_name VARCHAR(50),
  language_name   VARCHAR REFERENCES jcd_recruiting.language (name)
);

