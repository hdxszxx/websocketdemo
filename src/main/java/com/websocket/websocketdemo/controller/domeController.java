package com.websocket.websocketdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MacFan
 * user:created by MacFan
 * DATE: 2018/8/2
 */
@Controller
public class domeController {

    @RequestMapping("init")
    public String init(){
        return "dome";
    }
}
