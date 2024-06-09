package com.prashanth.urlshortener.controller;

import com.prashanth.urlshortener.model.TinyUrl;
import com.prashanth.urlshortener.service.TinyUrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TinyUrlController {

    private final TinyUrlService tinyUrlService;
    public TinyUrlController(TinyUrlService tinyUrlService) {
        this.tinyUrlService = tinyUrlService;
    }

    @GetMapping("/api/v1/tinyurls")
    public List<TinyUrl> getAllTinyUrls() {
        return tinyUrlService.getAllTinyUrls();
    }

}
