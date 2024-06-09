package com.prashanth.urlshortener.service;

import com.prashanth.urlshortener.model.TinyUrl;
import com.prashanth.urlshortener.repository.ShortenerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TinyUrlServiceTest {

    @Mock
    private ShortenerRepository shortenerRepository;

    @InjectMocks
    private TinyUrlService tinyUrlService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllTinyUrlsReturnsAllTinyUrls() {
        List<TinyUrl> expectedTinyUrls = Arrays.asList(
                new TinyUrl("http://example.com/1", "1"),
                new TinyUrl("http://example.com/2", "2")
        );
        when(shortenerRepository.findAll()).thenReturn(expectedTinyUrls);

        List<TinyUrl> actualTinyUrls = tinyUrlService.getAllTinyUrls();

        assertEquals(expectedTinyUrls, actualTinyUrls);
    }
}
