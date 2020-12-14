package com.handsomedong.manager.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Map<String, String> test() {
        Map<String, String> result = new HashMap<>();
        result.put("result", "This is a test.");
        return result;
    }
}
