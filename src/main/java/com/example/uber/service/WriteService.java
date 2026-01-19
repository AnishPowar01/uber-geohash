package com.example.uber.service;

public interface  WriteService<T, ID> {
    T create(T entity);

    T update(ID id, T entity);

    void deleteById(ID id);
}