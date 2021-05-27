package life.lieren.memorygarden.mapper;

import life.lieren.memorygarden.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);

    int addLikeCount(Comment comment);
}