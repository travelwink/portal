package travelwink.manage.bean;

import lombok.Data;

@Data
public class Message {
    int type;
    String content;

    public Message() {
    }

    public Message(int type, String content) {
        this.type = type;
        this.content = content;
    }
}
