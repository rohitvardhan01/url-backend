package com.assignment.notes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UrlController {
    @Autowired
    UrlMappingService service;

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody String url) {
        try {
            String shortCode = service.generateShortUrl(url);
            return ResponseEntity.ok(shortCode);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Invalid URL format.");
        }
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<String> redirect(@PathVariable String shortCode) {
    	return new ResponseEntity<>(service.getOriginalUrl(shortCode),HttpStatus.OK);
        
    }
}
