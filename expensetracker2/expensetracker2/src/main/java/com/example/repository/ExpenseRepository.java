package com.example.repository;

import com.example.model.Category;
import com.example.model.Expense;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface ExpenseRepository extends CrudRepository<Expense,Long> {
    @Query(value = "SELECT * FROM expense e JOIN category_type ct ON e.type_id = ct.id WHERE ct.category_id = :categoryId AND e.isactive=true AND e.expense_date BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<Expense> findCategoryId(Long categoryId,LocalDate startDate,LocalDate endDate);
    @Query(value = "SELECT e.*, c.* FROM expense e JOIN category_type c ON e.type_id = c.id", nativeQuery = true)
    List<Expense> findAll();


}
