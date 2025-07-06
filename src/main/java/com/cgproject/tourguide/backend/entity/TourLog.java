package com.cgproject.tourguide.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TourLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    private LocalDateTime date;
    private String comment;
    private int difficulty;
    private double totalDistance;
    private double totalTime;
    private int rating;

    public TourLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Tour getTour() { return tour; }
    public void setTour(Tour tour) { this.tour = tour; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public int getDifficulty() { return difficulty; }
    public void setDifficulty(int difficulty) { this.difficulty = difficulty; }

    public double getTotalDistance() { return totalDistance; }
    public void setTotalDistance(double totalDistance) { this.totalDistance = totalDistance; }

    public double getTotalTime() { return totalTime; }
    public void setTotalTime(double totalTime) { this.totalTime = totalTime; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }
}
