package com.chatter.controller;

import com.chatter.domain.Message;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Controller
@ServerEndpoint(value = "/chatter/{roomKey}",
        encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ChatEndpoint {
    private Session session;
    private String roomKey;
    private static Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(@PathParam("roomKey") String roomKey, Session session) throws IOException {
        this.session = session;
        this.roomKey = roomKey;
        chatEndpoints.add(this);

        Message message = new Message();
        message.setFrom(session.getId());
        message.setRoomKey(roomKey);
        message.setContent("Connected!");
        broadcast(message);
        // System.out.println(session.getId() + " opened at ChatEndpoint.onOpen with " + this.roomKey);
    }

    @OnMessage
    public void onMessage(@PathParam("roomKey") String roomKey, Session session, String content) throws IOException {
        Message message = new Message();
        message.setFrom(session.getId());
        message.setRoomKey(roomKey);
        message.setContent(content);
        broadcast(message);
        // System.out.println(session.getId() + " broadcast message : " + content);
    }

    @OnClose
    public void onClose(@PathParam("roomKey") String roomKey, Session session) throws IOException {
        chatEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(session.getId());
        message.setRoomKey(roomKey);
        message.setContent("Disconnected!");
        broadcast(message);
        // System.out.println(session.getId() + " closed at ChatEndpoint.onClose");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    private static void broadcast(Message message) throws IOException {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    if(endpoint.roomKey.equals(message.getRoomKey())) {
                        endpoint.session.getBasicRemote().sendObject(message);
                    }
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}