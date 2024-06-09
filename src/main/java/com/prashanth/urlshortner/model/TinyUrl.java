package com.prashanth.urlshortner.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "tiny_url")
@NoArgsConstructor
public class TinyUrl {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "longUrl", nullable = false)
    private String longUrl;

    @Column(name = "shortened_url_id", nullable = false)
    private String shortenedUrlId;

    public TinyUrl(String longUrl, String shortenedUrlId) {
        this.longUrl = longUrl;
        this.shortenedUrlId = shortenedUrlId;
    }
}
