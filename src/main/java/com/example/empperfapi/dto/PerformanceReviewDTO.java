package com.example.empperfapi.dto;

import java.time.LocalDate;

public class PerformanceReviewDTO {
    private LocalDate reviewDate;
    private Integer score;
    private String reviewComments;

    public PerformanceReviewDTO(LocalDate reviewDate, Integer score, String reviewComments) {
        this.reviewDate = reviewDate;
        this.score = score;
        this.reviewComments = reviewComments;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }
}

