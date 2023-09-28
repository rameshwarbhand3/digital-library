package com.ram.library.requestmodel;

import lombok.Data;

import java.util.Optional;

@Data
public class ReviewRequest {
    private double rating;
    private Long bookId;
    private Optional<String> reviewDescription;
}
