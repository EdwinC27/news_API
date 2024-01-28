package com.api.news.service;

import com.api.news.model.entity.RequestsNewsEntity;
import com.api.news.repository.RequestsNewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ServiceDataBase {
    @Autowired
    RequestsNewsRepo requestsNewsRepo;

    public boolean saveData(String type, String search, String totalResults) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = localDateTime.format(formatter);

            RequestsNewsEntity requestsNewsEntity = new RequestsNewsEntity();
            requestsNewsEntity.setTime(formattedDateTime);
            requestsNewsEntity.setType(type);
            requestsNewsEntity.setSearch(search);
            requestsNewsEntity.setTotalResults(totalResults);

            requestsNewsRepo.save(requestsNewsEntity);

            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
