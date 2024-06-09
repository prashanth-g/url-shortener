package com.prashanth.urlshortner.controller;

import com.prashanth.urlshortner.model.TinyUrl;
import com.prashanth.urlshortner.service.TinyUrlService;
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
