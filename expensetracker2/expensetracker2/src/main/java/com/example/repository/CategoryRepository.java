package com.example.repository;

import com.example.model.Category;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;


@JdbcRepository(dialect= Dialect.POSTGRES)

public interface CategoryRepository extends CrudRepository<Category, Long> {

}