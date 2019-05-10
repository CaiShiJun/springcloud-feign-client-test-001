package org.github.caishijun.springcloud.controller;

import org.github.caishijun.springcloud.service.FeignExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private FeignExampleService feignExampleService;

    @GetMapping("/feignClient/{name}")
    public String feignClient(@PathVariable("name") String name) {
        return feignExampleService.hello(name);
    }

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/restTemplate/{name}")
    public String restTemplate(@PathVariable("name") String name) {
        return this.restTemplate.getForObject("http://service-producer/hello?name=" + name, String.class);
    }

}