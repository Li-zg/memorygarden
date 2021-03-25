package life.lieren.memorygarden.enums;

public enum NotificationEnum {
    REPLY_QUESTION(1, "回复了问题"),
    REPLY_COMMENT(1, "回复了评论");

    private int type;
    private String name;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationEnum(int type, String name) {
        this.type = type;
        this.name = name;
    }
}
