package com.prashanth.urlshortener.service;

import com.prashanth.urlshortener.model.TinyUrl;
import com.prashanth.urlshortener.repository.ShortenerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TinyUrlService {

    private final ShortenerRepository shortenerRepository;
    public TinyUrlService(ShortenerRepository shortenerRepository) {
        this.shortenerRepository = shortenerRepository;
    }

    public List<TinyUrl> getAllTinyUrls() {
        return shortenerRepository.findAll();
    }
}
