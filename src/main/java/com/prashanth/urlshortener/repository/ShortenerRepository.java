package com.prashanth.urlshortener.repository;

import com.prashanth.urlshortener.model.TinyUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortenerRepository extends JpaRepository<TinyUrl, Long> {

    Optional<TinyUrl> findByShortenedUrlId(String shortenedUrlId);

}
