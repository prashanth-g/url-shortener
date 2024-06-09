package com.prashanth.urlshortner.service;

import com.prashanth.urlshortner.model.TinyUrl;
import com.prashanth.urlshortner.repository.ShortenerRepository;
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
