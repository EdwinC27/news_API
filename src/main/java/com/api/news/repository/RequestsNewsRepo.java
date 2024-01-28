package com.api.news.repository;

import com.api.news.model.entity.RequestsNewsEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RequestsNewsRepo extends JpaRepository<RequestsNewsEntity,String> {
}
