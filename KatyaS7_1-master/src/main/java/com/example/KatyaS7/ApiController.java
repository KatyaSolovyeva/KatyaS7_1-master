package com.example.KatyaS7;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class ApiController {
    List<String> messages=new ArrayList<>();

    @GetMapping("messages")
    public String getMessages(){
        StringBuilder stringBuilder=new StringBuilder();
        for(String message : messages) {
            stringBuilder.append(message).append(",");
        }
        return stringBuilder.toString();
    }

    @PostMapping("messages")
    public void addMessage(@RequestBody String message){
        messages.add(message);
    }

    @GetMapping("messages/{index}")
    public String getMessage(@PathVariable ("index") Integer index){
        return messages.get(index);
    }

    @DeleteMapping("messages/{index}")
    public void deleteText(@PathVariable("index") Integer index) {
        messages.remove((int) index);
    }

    @PutMapping("messages/{index}")
    public void updateMessage(@PathVariable ("index") Integer index,@RequestBody String message){
       messages.remove((int)index);
    }
}
//curl -X POST http://localhost:8080/messages -H 'Content-Type: text/plain' -d 'hello'
//curl https://localhost:8080/messages
//curl -H "Content-Type: text/plain"
//   -H "Accept: text/plain"
//   -d "Hello"