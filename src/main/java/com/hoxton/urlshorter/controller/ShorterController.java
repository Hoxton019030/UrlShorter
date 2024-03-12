package com.hoxton.urlshorter.controller;

import com.hoxton.urlshorter.request.CreateShortUrlRequest;
import com.hoxton.urlshorter.service.ShorterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;

@RequiredArgsConstructor
@Controller
@RequestMapping("hoxton/api")
public class ShorterController {

    private final ShorterService shorterService;

    @PostMapping("")
    public ResponseEntity<String> createShortUrl(@Validated CreateShortUrlRequest createShortUrlRequest){
        return shorterService.createShortUrl(createShortUrlRequest);
    }
    @GetMapping(value = "{shorUrl}")
    public ResponseEntity<Void> redirectUrl(@PathVariable("shorUrl")String shortUrl){
        return shorterService.findOriginUrl(shortUrl);
    }
}
