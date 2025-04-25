package com.example.productmanagerment.service;

import java.util.List;

public interface ProductService <E> {
    List<E> findAll();

    E findByName(String name);
    E findById(int id);
    void save(E e);
    E delete(int id);
    void update(E e, int id);
}
