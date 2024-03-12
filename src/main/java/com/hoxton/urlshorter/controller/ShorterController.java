package com.hoxton.urlshorter.controller;

import com.hoxton.urlshorter.request.CreateShortUrlRequest;
import com.hoxton.urlshorter.service.ShorterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequiredArgsConstructor
@Controller
@RequestMapping("hoxton/api")
@CrossOrigin // 注解方式
public class ShorterController {

    private final ShorterService shorterService;

    @PostMapping("")
    public ResponseEntity<String> createShortUrl(@Validated CreateShortUrlRequest createShortUrlRequest){
        System.out.println("createShortUrlRequest.getUrl() = " + createShortUrlRequest.getUrl());
        return shorterService.createShortUrl(createShortUrlRequest);
    }
    @GetMapping(value = "{shorUrl}")
    public ResponseEntity<Void> redirectUrl(@PathVariable("shorUrl")String shortUrl){
        return shorterService.findOriginUrl(shortUrl);
    }
}
