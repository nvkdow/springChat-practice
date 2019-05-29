package com.chatter.domain;

public class Message {
    private String roomKey;
    private String from;
    private String to;
    private String content;

    public String getRoomKey() { return roomKey; }
    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getContent() { return content; }

    public void setRoomKey(String roomKey) { this.roomKey = roomKey; }
    public void setFrom(String sender) { this.from = sender; }
    public void getTo(String receiver) { this.to = receiver; }
    public void setContent(String message) { this.content = message; }

    @Override
    public String toString() {
        return "Message{" +
                "roomKey='" + roomKey + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
