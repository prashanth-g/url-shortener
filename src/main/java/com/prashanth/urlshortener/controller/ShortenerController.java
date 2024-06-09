package com.prashanth.urlshortener.controller;

import com.prashanth.urlshortener.service.ShortenerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShortenerController {

    private final ShortenerService shortenerService;
    public ShortenerController(ShortenerService shortenerService) {
        this.shortenerService = shortenerService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/{shortenedUrlId}")
    public String redirect(@PathVariable String shortenedUrlId) {
        String longUrl = shortenerService.getLongUrl(shortenedUrlId);
        return "redirect:" + longUrl;
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam("url") String longUrl, Model model) {
        String shortUrl = shortenerService.shorten(longUrl);
        model.addAttribute("shortUrl", shortUrl);
        return "result";
    }
}
