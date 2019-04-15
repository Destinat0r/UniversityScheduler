package com.foxminded.university.service;

import java.util.List;

public interface EntityService<T> {

    T create(T t);
    
    T findById(int id);
    
    List<T> findAll();
    
    void deleteById(int id);
}
