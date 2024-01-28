package com.api.news.controller;

import com.api.news.configuration.CheckInternetConnection;
import com.api.news.model.constants.EndPoints;
import com.api.news.service.NewsBy;
import com.api.news.service.ServiceDataBase;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndPoints.BASE_URL)
public class GetNewsByCategory {

    @Autowired
    NewsBy newsByDate;

    @Autowired
    CheckInternetConnection checkInternetConnection;

    @Autowired
    ServiceDataBase serviceDataBase;

    @GetMapping(EndPoints.NEWS_CATEGORY)
    public ResponseEntity<JSONObject> getNewsByCategory(@RequestParam(value = "category", required = true) String category) throws Exception {
        //  Possible options: business, entertainment, general, health, science, sports, technology

        boolean isConnected = checkInternetConnection.connection();

        JSONObject jsonResponse = newsByDate.getNewCategory(category);
        String totalResults = jsonResponse.get("totalResults").toString();

        boolean sendInfo = serviceDataBase.saveData("Category news", category, totalResults);
        if (sendInfo) {
            jsonResponse.put("dataSaved", true);
        } else {
            jsonResponse.put("dataSaved", false);
        }

        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

}
