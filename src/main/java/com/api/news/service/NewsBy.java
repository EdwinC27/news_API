package com.api.news.service;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.time.LocalDate;

@Service
public class NewsBy {

    @Value("${apiKey}")
    private String apiKey;

    @Value("${authUrlNews}")
    private String apiUrl;

    WebClient webClient = WebClient.create();

    public JSONObject getNewToday(String typeNews) throws IOException {
        LocalDate date = LocalDate.now();
        String url= apiUrl + "everything?q=" + typeNews + "&from=" + date + "&to=" + date + "&sortBy=popularity&apiKey=" + apiKey;

        String response = peticionUrl(url);
        return (JSONObject) JSONValue.parse(response);
    }

    public JSONObject getNewDate(String typeNews, String from, String to) throws IOException {
        String url= apiUrl + "everything?q=" + typeNews + "&from=" + from + "&to=" + to + "&sortBy=popularity&apiKey=" + apiKey;

        String response = peticionUrl(url);
        return (JSONObject) JSONValue.parse(response);
    }
     public JSONObject getNewDomain(String domains) throws IOException {
         String url= apiUrl + "everything?domains=" + domains + "&apiKey=" + apiKey;

         String response = peticionUrl(url);
         return (JSONObject) JSONValue.parse(response);
     }

    public JSONObject getNewCategory(String category) throws IOException {
        String url= apiUrl + "top-headlines?category=" + category + "&apiKey=" + apiKey;

        String response = peticionUrl(url);
        return (JSONObject) JSONValue.parse(response);
    }

     private String peticionUrl(String url) throws IOException  {
        String response = webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        return response;
    }
}
