package com.chatter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

@Controller
public class ChatController {

    @RequestMapping("/chat/begin")
    public String showChatBegin(ModelMap modelMap) {
        Random randGen = new Random();
        float randf = randGen.nextFloat();

        String roomKey = encodeMD5(Float.toString(randf));
        modelMap.addAttribute("roomKey" , roomKey);

        return "/chat/begin";
    }

    @RequestMapping("/chat/{roomKey}")
    public String showChatRoom(@PathVariable("roomKey") String roomKey, ModelMap modelMap) {
        System.out.println("roomKey : " + roomKey);
        modelMap.addAttribute("roomKey", roomKey);
        return "/chat/room";
    }

    private String encodeMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] mdBytes = md.digest();

            StringBuilder output = new StringBuilder();
            for(byte b : mdBytes) {
                String hexString = String.format("%02x", b);
                output.append(hexString);
            }

            return output.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
