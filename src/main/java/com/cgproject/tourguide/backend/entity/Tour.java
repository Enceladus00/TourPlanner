package com.cgproject.tourguide.backend.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String fromLocation;
    private String toLocation;
    private String transportType;
    private double distance;
    private double estimatedTime;
    private String mapImagePath;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TourLog> logs;

    public Tour() {
        this.logs = new java.util.ArrayList<>();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getFromLocation() { return fromLocation; }
    public void setFromLocation(String fromLocation) { this.fromLocation = fromLocation; }

    public String getToLocation() { return toLocation; }
    public void setToLocation(String toLocation) { this.toLocation = toLocation; }

    public String getTransportType() { return transportType; }
    public void setTransportType(String transportType) { this.transportType = transportType; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public double getEstimatedTime() { return estimatedTime; }
    public void setEstimatedTime(double estimatedTime) { this.estimatedTime = estimatedTime; }

    public String getMapImagePath() { return mapImagePath; }
    public void setMapImagePath(String mapImagePath) { this.mapImagePath = mapImagePath; }

    public List<TourLog> getLogs() {
        return logs == null ? java.util.Collections.emptyList() : logs;
    }
    public void setLogs(List<TourLog> logs) { this.logs = logs; }
}
