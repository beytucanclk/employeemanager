CREATE TABLE employee
(
    id        BIGINT NOT NULL,
    name      VARCHAR(255) NULL,
    surname   VARCHAR(255) NULL,
    email     VARCHAR(255) NULL,
    job_title VARCHAR(255) NULL,
    phone     VARCHAR(255) NULL,
    image_url VARCHAR(255) NULL,
    CONSTRAINT pk_employee PRIMARY KEY (id)
);