package com.insigma.download.controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/test")
public class Test {
    @ResponseBody
    @RequestMapping("/query")
    public String query(HttpServletRequest request, HttpServletResponse response) {
        return "asdadasd";
    }
}
