package life.lieren.memorygarden.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND(2001,"你找的问题已经不存在了~"),
    TARGET_PARAM_NOT_FOUND(2002,"未选中任何评论进行回复!"),
    NOT_LOGIN(2003,"当前操作未登录不能进行，请先登录！"),
    SYS_ERROR(2004,"服务器出了点小问题~"),
    TYPE_PARAM_WRONG(2005,"评论类型错误或不存在"),
    COMMENT_NOT_FOUND(2006,"回复的评论不存在！"),
    CONTENT_IS_EMPTY(2007,"回复内容不能为空！"),
    READ_UNAUTHORIZED_NOTIFICATION(2008,"搁这看别人的消息通知呐？"),
    NOTIFICATION_NOT_FOUND(2009,"消息通知未找到？")
    ;
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }


    private Integer code;
    private String message;

    CustomizeErrorCode(Integer code, String message) {
        this.message = message;
        this.code = code;
    }
}
