package com.prashanth.urlshortener.service;

import com.prashanth.urlshortener.model.Counter;
import com.prashanth.urlshortener.model.TinyUrl;
import com.prashanth.urlshortener.repository.CounterRepository;
import com.prashanth.urlshortener.repository.ShortenerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortenerService {

    private final ShortenerRepository shortenerRepository;
    private final CounterRepository counterRepository;
    public ShortenerService(ShortenerRepository shortenerRepository, CounterRepository counterRepository) {
        this.shortenerRepository = shortenerRepository;
        this.counterRepository = counterRepository;
    }

    private static final String BASE62_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int BASE = 62;

    public String shorten(String longUrl) {

        // Get the counter value
        final Optional<Counter> counter = counterRepository.findById(1L);
        final long counterValue = counter.map(Counter::getCount).orElse(100000L);

        // Encode the URL
        final String shortenedUrlId = encodeBase62(counterValue);

        // Save the URL in the database
        shortenerRepository.save(new TinyUrl(longUrl, shortenedUrlId));
        counterRepository.save(new Counter(1L, counterValue + 1));

        // Return the shortened URL
        return "http://localhost:8080/" + shortenedUrlId;
    }

    // Encode a number into a Base62 string
    public static String encodeBase62(long number) {
        if (number == 0) {
            return String.valueOf(BASE62_ALPHABET.charAt(0));
        }

        final StringBuilder base62 = new StringBuilder();
        while (number > 0) {
            final int remainder = (int) (number % BASE);
            base62.append(BASE62_ALPHABET.charAt(remainder));
            number /= BASE;
        }

        return base62.reverse().toString();
    }

    public String getLongUrl(String shortenedUrlId) {
        // Retrieve the URL from the database
        TinyUrl tinyUrl = shortenerRepository
                .findByShortenedUrlId(shortenedUrlId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid URL"));

        // Return the long URL
        return tinyUrl.getLongUrl();
    }
}
