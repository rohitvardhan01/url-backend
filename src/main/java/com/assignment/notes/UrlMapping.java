package com.assignment.notes;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.*;
import lombok.*;

@Entity
public class UrlMapping {
    @Id
    private String shortCode;

    private String originalUrl;
    private LocalDateTime createdAt;
	
	public UrlMapping(String shortCode, String originalUrl, LocalDateTime createdAt) {
		super();
		this.shortCode = shortCode;
		this.originalUrl = originalUrl;
		this.createdAt = createdAt;
	}
	public UrlMapping() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(createdAt, originalUrl, shortCode);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UrlMapping other = (UrlMapping) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(originalUrl, other.originalUrl)
				&& Objects.equals(shortCode, other.shortCode);
	}
	public String getShortCode() {
		return shortCode;
	}
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
	}
	public String getOriginalUrl() {
		return originalUrl;
	}
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
