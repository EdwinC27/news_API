package com.api.news.service;

import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class NewsByDate {

    @Value("${apiKey}")
    private String apiKey;

    @Value("${authUrlNews}")
    private String apiUrl;

        WebClient webClient = WebClient.create();

        private static final Logger LOGGER = LoggerFactory.getLogger(NewsByDate.class);

        public JSONObject getNewToday(String typeNews) throws IOException {
            LocalDate date = LocalDate.now();
            String url= apiUrl + "q=" + typeNews + "&from=" + date + "&to=" + date + "&sortBy=popularity&apiKey=" + apiKey;

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