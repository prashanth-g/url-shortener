package com.prashanth.urlshortner.repository;

import com.prashanth.urlshortner.model.Counter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<Counter, Long> {
}
