package edu.AvaliadorFilmesSeries.application.service.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IService<T> {
     ResponseEntity<List<T>> getAll();
     void delete(int id);
}
