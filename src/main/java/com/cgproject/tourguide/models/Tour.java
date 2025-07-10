package com.cgproject.tourguide.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Tour {
    private Integer id; // <--- add this line!
    private String name;
    @SerializedName("description")
    private String tourDescription;
    @SerializedName("fromLocation")
    private String from;
    @SerializedName("toLocation")
    private String to;
    private String transportType;
    @SerializedName("distance")
    private double tourDistance;
    private double estimatedTime;
    private String routeInformation;
    private List<TourLog> tourLogs;

    // Constructor (for new tours)
    public Tour(String name, String tourDescription, String from, String to, String transportType, double tourDistance, double estimatedTime, String routeInformation) {
        this(null, name, tourDescription, from, to, transportType, tourDistance, estimatedTime, routeInformation);
    }

    // Constructor (for tours with known ID)
    public Tour(Integer id, String name, String tourDescription, String from, String to, String transportType, double tourDistance, double estimatedTime, String routeInformation) {
        this.id = id;
        this.name = name;
        this.tourDescription = tourDescription;
        this.from = from;
        this.to = to;
        this.transportType = transportType;
        this.tourDistance = tourDistance;
        this.estimatedTime = estimatedTime;
        this.routeInformation = routeInformation;
        this.tourLogs = new ArrayList<>();
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTourDescription() {
        return tourDescription;
    }

    public void setTourDescription(String tourDescription) {
        this.tourDescription = tourDescription;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public double getTourDistance() {
        return tourDistance;
    }

    public void setTourDistance(double tourDistance) {
        this.tourDistance = tourDistance;
    }

    public double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getRouteInformation() {
        return routeInformation;
    }

    public void setRouteInformation(String routeInformation) {
        this.routeInformation = routeInformation;
    }
    public List<TourLog> getTourLogs() {
        if (tourLogs == null) return new ArrayList<>();
        return tourLogs;
    }
    public void setTourLogs(List<TourLog> tourLogs) {
        if (tourLogs == null) {
            this.tourLogs = new ArrayList<>();
        } else {
            this.tourLogs = tourLogs;
        }
    }
    public void addTourLog(TourLog tourLog) {
        this.tourLogs.add(tourLog);
    }
    public void removeTourLog(TourLog tourLog) {
        this.tourLogs.remove(tourLog);
    }
}
