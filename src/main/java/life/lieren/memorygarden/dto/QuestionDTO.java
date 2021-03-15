package life.lieren.memorygarden.dto;

import life.lieren.memorygarden.model.User;
import lombok.Data;

@Data
public class QuestionDTO {
    private Long id;
    private String  title;
    private String  description;
    private String  tag;
    private Long    gmtCreate;
    private Long    gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private User    user;
}
