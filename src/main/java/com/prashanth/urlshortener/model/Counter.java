package com.prashanth.urlshortener.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "counter")
@NoArgsConstructor
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "count", nullable = false)
    private Long count;

    public Counter(Long count) {
        this.count = count;
    }

    public Counter(long id, long count) {
        this.id = id;
        this.count = count;
    }
}
