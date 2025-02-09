package com.example.repository;

import com.example.model.Category;
import com.example.model.CategoryType;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface CategoryTypeRepository extends CrudRepository<CategoryType,Long> {
List<CategoryType> findByCategory_Id(Long id);
}
