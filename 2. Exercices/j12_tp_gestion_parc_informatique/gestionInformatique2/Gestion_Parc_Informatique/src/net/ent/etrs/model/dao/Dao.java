package net.ent.etrs.model.dao;

public interface Dao<T> {
    void create(T element);
    T read(String id);
    void delete(T element);
    void update(T element);
}