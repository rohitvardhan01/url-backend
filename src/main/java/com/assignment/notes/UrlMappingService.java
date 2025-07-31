package com.assignment.notes;

import java.time.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlMappingService {
    @Autowired
    UrlMappingRepository repository;

    public String generateShortUrl(String originalUrl) {
        // Validate URL format
        if (!originalUrl.matches("^(http|https)://.*$")) {
            throw new IllegalArgumentException("Invalid URL format");
        }

        Optional<UrlMapping> existing = repository.findByOriginalUrl(originalUrl.trim());
        if (existing.isPresent()) return existing.get().getShortCode();

        String shortCode = UUID.randomUUID().toString().substring(0, 8);
        repository.save(new UrlMapping(shortCode, originalUrl, LocalDateTime.now()));
        return shortCode;
    }

    public String getOriginalUrl(String shortCode) {
        UrlMapping mapping = repository.findById(shortCode).orElse(null);
        if (mapping == null) return "NOT_FOUND";

        if (Duration.between(mapping.getCreatedAt(), LocalDateTime.now()).toMinutes() > 5) {
            return "EXPIRED";
        }

        return mapping.getOriginalUrl();
    }
}
