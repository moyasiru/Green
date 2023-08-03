package com.boot.chat;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {

    @GetMapping("/chat")
    public String index(){
        return "error";
    }

    @GetMapping("/chat/{id}")
    public String chattingRoom(@PathVariable String id, HttpSession session, Model model){
//        if(id.equals("guest")){
//            model.addAttribute("name", "guest");
//        }else if(id.equals("master")){
//            model.addAttribute("name", "master");
//        }else if(id.equals("loose")){
//            model.addAttribute("name", "loose");
//        }else {
//            return "error";
//        }
        String user_id = (String) session.getAttribute("user_id");
        if (user_id != null) {
            model.addAttribute("name", user_id);
        }else {
        	model.addAttribute("name", "guest");
        }
        return "chattingRoom2";
    }
    
}