CREATE TABLE COMMENT
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    parent_id BIGINT NOT NULL,
    type int NOT NULL,
    commentator bigint NOT NULL,
    gmt_create BIGINT NOT NULL,
    gmt_modified BIGINT NOT NULL,
    like_count BIGINT DEFAULT 0,
    content VARCHAR(1024) NOT NULL
);