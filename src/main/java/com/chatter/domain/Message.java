package com.chatter.domain;

public class Message {
    private String from;
    private String to;
    private String content;

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public String getContent() { return content; }
    public void setFrom(String sender) { this.from = sender; }
    public void getTo(String receiver) { this.to = receiver; }
    public void setContent(String message) { this.content = message; }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + from + '\'' +
                ", receiver='" + to + '\'' +
                ", message='" + content + '\'' +
                '}';
    }
}
