package indi.wuyue.hmily.dubbo.provider.a.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/a")
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        return "success";
    }
}
