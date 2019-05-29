package com.chatter.controller;

import com.chatter.domain.Message;
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
    private static Set<ChatEndpoint> chatEndpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("roomKey") String roomKey) throws IOException {
        System.out.println("onOpen Method called with " + roomKey);
        this.session = session;
        chatEndpoints.add(this);

        Message message = new Message();
        message.setRoomKey(roomKey);
        message.setContent("Connected!");
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, String content) throws IOException {
        System.out.println("received message : " + content);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent(content);
        broadcast(message);
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("onClose method called");
        chatEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("Disconnected!");
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    private static void broadcast(Message message) throws IOException {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().
                            sendObject(message);
                } catch (IOException | EncodeException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}