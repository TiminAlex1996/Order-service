package ru.sber.orderservice.mapper;

public interface Mapper<F, T> {
    T map(F object);
}
