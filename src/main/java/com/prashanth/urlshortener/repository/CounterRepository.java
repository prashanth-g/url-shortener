package com.prashanth.urlshortener.repository;

import com.prashanth.urlshortener.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter, Long> {
}
