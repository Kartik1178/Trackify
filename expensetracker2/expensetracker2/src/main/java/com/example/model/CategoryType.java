package com.example.model;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Serdeable
@MappedEntity
public class CategoryType {
@Id
    @GeneratedValue
    private Long id;
@Column(name="name")
    private  String name;

@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name="category_id",nullable = false)
    private Category category;

@OneToMany(mappedBy = "categoryTypes")
private List<Expense> expenses= new ArrayList<>();
public CategoryType(){

}
public CategoryType(String name,Category category){
    this.name=name;
    this.category=category;
}
public String getName(){
    return name;
}
public void setName(String name){
    this.name=name;
}
public Long getId(){
    return id;
    }
   public void setId(Long id){
    this.id=id
;   }
public Category getCategory(){
    return category;
}
public void setCategory(Category category){
    this.category=category;
}
public List<Expense> getExpenses(){
    return expenses;
}
public void setExpenses(List<Expense> expenses){
    this.expenses=expenses;
}
}
