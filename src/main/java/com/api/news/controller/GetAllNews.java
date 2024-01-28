package com.api.news.controller;

import com.api.news.configuration.CheckInternetConnection;
import com.api.news.model.constants.EndPoints;
import com.api.news.service.NewsByDate;

import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
@RequestMapping(EndPoints.BASE_URL)
public class GetAllNews {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetAllNews.class);

    @Autowired
    NewsByDate newsByDate;

    @Autowired
    CheckInternetConnection checkInternetConnection;

    @GetMapping(EndPoints.NEWS_TODAY)
    public ResponseEntity<JSONObject> getAllNews(@RequestParam(value = "type", required = true) String typeNew) throws Exception {
        boolean isConnected = checkInternetConnection.connection();

        JSONObject jsonResponse = newsByDate.getNewToday(typeNew);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

}
