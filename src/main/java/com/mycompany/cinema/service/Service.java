package com.mycompany.cinema.service;

import java.util.List;

public interface Service<T> {
    List<T> getAll();
    void saveAll(List<T> tList);
}
