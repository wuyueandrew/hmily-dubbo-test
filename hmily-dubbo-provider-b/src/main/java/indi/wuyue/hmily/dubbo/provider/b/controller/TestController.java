package indi.wuyue.hmily.dubbo.provider.b.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/b")
public class TestController {

    @GetMapping(value = "/test")
    public String test() {
        return "success";
    }
}
