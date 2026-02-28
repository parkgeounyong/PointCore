CREATE SEQUENCE data_user_seq START 1;

CREATE TABLE data_user (
                           seq_id BIGINT PRIMARY KEY DEFAULT nextval('data_user_seq'),
                           user_id VARCHAR(50) NOT NULL UNIQUE,
                           pw VARCHAR(255) NOT NULL,
                           name VARCHAR(100) NOT NULL,
                           phone VARCHAR(20) NOT NULL,
                           ent_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
                           upd_date TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP
);