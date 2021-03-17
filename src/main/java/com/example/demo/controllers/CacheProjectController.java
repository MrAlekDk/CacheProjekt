package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.Cache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CacheProjectController {

    private Cache userCache = new Cache();

    @GetMapping(value = "/")
    @ResponseBody
    public String endPoint() throws InterruptedException {
        return "standard-endpoint";
    }

    @GetMapping(value = "/get-user-data")
    @ResponseBody
    public String showString(@RequestParam int id) throws InterruptedException {


       if(userCache.has(id)){
           return userCache.get(id);

       } else{
            User tmp = new User(id);
            String randomString = tmp.getDataSlow();
            userCache.set(id,randomString);
            userCache.setTTL(id,10000);
            return randomString;
        }

    }

}
