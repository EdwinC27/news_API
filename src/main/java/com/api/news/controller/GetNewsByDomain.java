package com.api.news.controller;

import com.api.news.configuration.CheckInternetConnection;
import com.api.news.model.constants.EndPoints;
import com.api.news.service.NewsBy;
import com.api.news.service.ServiceDataBase;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.BASE_URL)
public class GetNewsByDomain {
    private static final Logger LOGGER = LoggerFactory.getLogger(GetNewsByDomain.class);

    @Autowired
    NewsBy newsByDate;

    @Autowired
    CheckInternetConnection checkInternetConnection;

    @Autowired
    ServiceDataBase serviceDataBase;

    @GetMapping(EndPoints.NEWS_DOMAIN)
    public ResponseEntity<JSONObject> getAllNews(@RequestParam(value = "domains", required = true) String domain) throws Exception {
        //  Possible options: bbc.co.uk, techcrunch.com, engadget.com

        boolean isConnected = checkInternetConnection.connection();

        JSONObject jsonResponse = newsByDate.getNewDomain(domain);
        String totalResults = jsonResponse.get("totalResults").toString();

        boolean sendInfo = serviceDataBase.saveData("Domains news", domain, totalResults);
        if (sendInfo) {
            jsonResponse.put("dataSaved", true);
        } else {
            jsonResponse.put("dataSaved", false);
        }

        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

}