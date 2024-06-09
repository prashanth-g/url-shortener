package com.prashanth.urlshortner.repository;

import com.prashanth.urlshortner.model.TinyUrl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortenerRepository extends JpaRepository<TinyUrl, Long> {

    Optional<TinyUrl> findByShortenedUrlId(String shortenedUrlId);

}
