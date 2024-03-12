package com.hoxton.urlshorter.service;

import com.hoxton.urlshorter.entity.Url;
import com.hoxton.urlshorter.mapper.ShorterMapper;
import com.hoxton.urlshorter.request.CreateShortUrlRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ShorterService {
    private static final String allowedString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private final ShorterMapper shorterMapper;

    public ResponseEntity<String> createShortUrl(CreateShortUrlRequest createShortUrlRequest) {
        boolean duplicated =true;
        String base62String="";
        while (duplicated){
            base62String = generateBase62String(createShortUrlRequest.getUrl(),createShortUrlRequest.getSize());
            Url shortUrl = shorterMapper.findByShortURL(base62String);
            //如果shortUrl是空的，代表不重複，可以創建
            if(shortUrl==null){
                duplicated=false;
            }
        }
        Url url = new Url();
        url.setShortUrl(base62String);
        url.setOriginUrl(createShortUrlRequest.getUrl());
        url.setCreateTime(new Date());
        shorterMapper.insert(url);
        return ResponseEntity.ok().body(base62String);
    }

   public String generateBase62String(String url, Integer size){
       String shortURL;
       char[] charArray = new char[size];

       for(int i = 0;i<size;i++){
           int randomIndex = (int) (Math.random() * allowedString.length());
           char c = allowedString.charAt(randomIndex);
           charArray[i]=c;
       }
       shortURL =String.valueOf(charArray);
       return shortURL;
   }

    public ResponseEntity<Void> findOriginUrl(String shortUrl) {
        Url byShortURL = shorterMapper.findByShortURL(shortUrl);
        System.out.println("byShortURL = " + byShortURL);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(byShortURL.getOriginUrl()))
                .build();
    }
}
