CREATE TABLE notification
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    notifier BIGINT NOT NULL,
    reciever BIGINT NOT NULL,
    outerid BIGINT NOT NULL,
    type int NOT NULL,
    gmtCreate BIGINT NOT NULL,
    type int DEFAULT 0 NOT NULL
);