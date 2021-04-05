CREATE TABLE notification
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    notifier BIGINT NOT NULL,
    reciever BIGINT NOT NULL,
    outerid BIGINT NOT NULL,
    type int NOT NULL,
    gmtCreate BIGINT NOT NULL,
    status int DEFAULT 0 NOT NULL,
    notifier_name VARCHAR(100) NOT NULL,
    outer_title VARCHAR(256) NOT NULL
);