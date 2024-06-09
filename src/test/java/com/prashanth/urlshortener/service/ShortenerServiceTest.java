package com.prashanth.urlshortener.service;

import com.prashanth.urlshortener.model.Counter;
import com.prashanth.urlshortener.model.TinyUrl;
import com.prashanth.urlshortener.repository.CounterRepository;
import com.prashanth.urlshortener.repository.ShortenerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ShortenerServiceTest {

    @Mock
    private ShortenerRepository shortenerRepository;

    @Mock
    private CounterRepository counterRepository;

    @InjectMocks
    private ShortenerService shortenerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shortenWithExistingCounter() {
        Counter counter = new Counter(1L, 100000L);

        when(counterRepository.findById(1L)).thenReturn(Optional.of(counter));
        when(shortenerRepository.save(any(TinyUrl.class))).thenReturn(null);
        when(counterRepository.save(any(Counter.class))).thenReturn(null);

        String result = shortenerService.shorten("http://example.com");

        assertEquals("http://localhost:8080/aA4", result);
    }

    @Test
    void shortenWithoutExistingCounter() {
        when(counterRepository.findById(1L)).thenReturn(Optional.empty());
        when(shortenerRepository.save(any(TinyUrl.class))).thenReturn(null);
        when(counterRepository.save(any(Counter.class))).thenReturn(null);

        String result = shortenerService.shorten("http://example.com");

        assertEquals("http://localhost:8080/aA4", result);
    }

    @Test
    void getLongUrlWithExistingTinyUrl() {
        when(shortenerRepository.findByShortenedUrlId("1")).thenReturn(Optional.of(new TinyUrl("http://example.com", "1")));

        String result = shortenerService.getLongUrl("1");

        assertEquals("http://example.com", result);
    }

    @Test
    void getLongUrlWithoutExistingTinyUrl() {
        when(shortenerRepository.findByShortenedUrlId("1")).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> shortenerService.getLongUrl("1"));
    }
}
