package com.cgproject.tourguide.models;

import java.time.LocalDateTime;

public class TourLog {
    private double date;
    private double time;
    private String comment;
    private double difficulty;
    private double totalDistance;
    private double totalTime;
    private double rating;

    // Constructor
    public TourLog(double date, double time, String comment, double difficulty, double totalDistance, double totalTime, double rating) {
        this.date = date;
        this.time = time;
        this.comment = comment;
        this.difficulty = difficulty;
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.rating = rating;
    }

    // Getters and Setters
    public double getDate() {
        return date;
    }
    public double getTime() {
        return time;
    }
    public void setTime(double time) {
        this.time = time;
    }
    public void setDate(double date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}