package com.bobwares.poc.resource;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointsResource {

    @GetMapping(path = "points")
    public Object get() {
        return "hello World";
    }

    @PostMapping(path = "points")
    public Object post(HttpRequest httpRequest) {
        return "hello World";
    }
}
