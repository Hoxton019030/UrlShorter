package com.hoxton.urlshorter.request;

import lombok.Data;

@Data
public class CreateShortUrlRequest {
    /**
     * 要轉換的url
     */
    String url;
    /**
     * 要轉化成多少的短網址
     */
    Integer size;
}
