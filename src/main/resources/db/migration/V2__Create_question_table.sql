CREATE TABLE question
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    title varchar(50),
    description text,
    gmt_create bigint,
    gmt_modified bigint,
    creator bigint NOT NULL,
    comment_count int DEFAULT 0,
    view_count int DEFAULT 0,
    like_count int DEFAULT 0,
    tag varchar(256)
);