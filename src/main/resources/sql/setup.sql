CREATE TABLE PET (
                     ID BIGSERIAL PRIMARY KEY,
                     NAME VARCHAR NOT NULL,
                     CATEGORY VARCHAR NOT NULL,
                     BIO  VARCHAR NOT NULL,
                     STATUS VARCHAR NOT NULL,
                     PHOTO_URLS VARCHAR NOT NULL,
                     TAGS VARCHAR NOT NULL
);

CREATE TABLE ORDERS (
                        ID BIGSERIAL PRIMARY KEY,
                        PET_ID INT NOT NULL REFERENCES PET (ID) ON DELETE CASCADE,
                        SHIP_DATE TIMESTAMP NULL,
                        STATUS VARCHAR NOT NULL,
                        COMPLETE BOOLEAN NOT NULL
);

CREATE TABLE USERS (
                       ID BIGSERIAL PRIMARY KEY,
                       USER_NAME VARCHAR NOT NULL UNIQUE,
                       FIRST_NAME VARCHAR NOT NULL,
                       LAST_NAME VARCHAR NOT NULL,
                       EMAIL VARCHAR NOT NULL,
                       HASH VARCHAR NOT NULL,
                       PHONE VARCHAR NOT NULL
);

CREATE TABLE JWT (
                     ID VARCHAR PRIMARY KEY,
                     JWT VARCHAR NOT NULL,
    -- BIGINT instead of BIGSERIAL
                     IDENTITY BIGINT NOT NULL REFERENCES USERS (ID) ON DELETE CASCADE,
                     EXPIRY TIMESTAMP NOT NULL,
                     LAST_TOUCHED TIMESTAMP
);

ALTER TABLE ORDERS
    ADD USER_ID BIGINT NOT NULL REFERENCES USERS (ID) ON DELETE CASCADE;

ALTER TABLE USERS
    ADD ROLE VARCHAR NOT NULL DEFAULT 'Customer'
