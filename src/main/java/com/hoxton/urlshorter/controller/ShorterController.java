package com.hoxton.urlshorter.controller;

import com.hoxton.urlshorter.request.CreateShortUrlRequest;
import com.hoxton.urlshorter.service.ShorterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("hoxton/api")
public class ShorterController {

    private final ShorterService shorterService;

    @PostMapping("")
    public ResponseEntity<String> createShortUrl(@Validated CreateShortUrlRequest createShortUrlRequest){
        return shorterService.createShortUrl(createShortUrlRequest);
    }
}
