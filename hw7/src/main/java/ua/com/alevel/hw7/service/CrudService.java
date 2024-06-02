package ua.com.alevel.hw7.service;

import ua.com.alevel.hw7.entity.BaseEntity;

import java.util.Collection;

public interface CrudService <E extends BaseEntity> {
    void create(E entity);
    void update(E entity);
    void delete(String id);
    E findById(String id);
    Collection<E> findAll();
}
