package com.mycompany.cinema.repository;

import java.util.List;

public interface FileRepository<T> {
    void saveAll(List<T> tList);
    List<T> findAll();
}
