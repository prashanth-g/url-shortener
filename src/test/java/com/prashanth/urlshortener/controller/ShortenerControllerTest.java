package com.prashanth.urlshortener.controller;

import com.prashanth.urlshortener.service.ShortenerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ShortenerControllerTest {

    @Mock
    private ShortenerService shortenerService;

    @Mock
    private Model model;

    @InjectMocks
    private ShortenerController shortenerController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void homeReturnsHomePage() {
        String result = shortenerController.home();
        assertEquals("home", result);
    }

    @Test
    void redirectRedirectsToLongUrl() {
        when(shortenerService.getLongUrl("1")).thenReturn("http://example.com");
        String result = shortenerController.redirect("1");
        assertEquals("redirect:http://example.com", result);
    }

    @Test
    void shortenUrlReturnsResultPageAndAddsShortUrlToModel() {
        when(shortenerService.shorten("http://example.com")).thenReturn("http://localhost:8080/1");
        String result = shortenerController.shortenUrl("http://example.com", model);
        assertEquals("result", result);
        verify(model).addAttribute("shortUrl", "http://localhost:8080/1");
    }
}
