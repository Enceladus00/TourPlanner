package com.cgproject.tourguide.util;

import com.cgproject.tourguide.backend.entity.Tour;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class RestClient {
    private static final String BASE_URL = "http://localhost:8080/api/tours";
    private static final Gson gson = new Gson();

    public static List<Tour> getAllTours() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), new TypeToken<List<Tour>>(){}.getType());
    }

    public static Tour addTour(Tour tour) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        String json = gson.toJson(tour);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return gson.fromJson(response.body(), Tour.class);
    }
}
