package com.cgproject.tourguide.util;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RouteService {
    private static final String API_KEY = "TODO_YOUR_API_KEY";
    private static final String BASE_URL = "https://api.openrouteservice.org/v2/directions/foot-walking";

    public static String getRoute(double startLon, double startLat, double endLon, double endLat) throws Exception {
        String url = BASE_URL + "?api_key=" + API_KEY +
                "&start=" + startLon + "," + startLat +
                "&end=" + endLon + "," + endLat;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
