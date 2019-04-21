package com.sgz.microserviceconsumermovie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author sby
 * @Title: HelloService
 * @Description: TODO
 * @date 2019/4/21 14:47
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        return restTemplate.getForObject("http://zuul/user/hi/" + name, String.class);
    }

}
