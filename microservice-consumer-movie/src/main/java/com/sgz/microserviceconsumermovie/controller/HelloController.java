package com.sgz.microserviceconsumermovie.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sgz.microserviceconsumermovie.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sby
 * @Title: HelloController
 * @Description: TODO
 * @date 2019/4/21 14:53
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @HystrixCommand(fallbackMethod = "fallHi")
    @GetMapping(value = "/hi/{name}")
    public String hi(@PathVariable String name) {
        return helloService.hiService(name);
    }

    public String fallHi(String name) {
        return "movie:" + name;
    }

}
