package com.example.model;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Introspected
@Serdeable
@MappedEntity
public class Category {
   @Id
   @GeneratedValue
   private Long id;

   @Column(name="name")
   private String name;

@OneToMany(mappedBy = "category",cascade = CascadeType.ALL,orphanRemoval = true)
private List<CategoryType>categoryTypes=new ArrayList<>();

public Category() {
}

public Category(String name) {
    this.name = name;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
public  List<CategoryType> getCategoryTypes() {
    return categoryTypes;
}
public void setCategoryTypes(List<CategoryType> categoryTypes) {
        this.categoryTypes=categoryTypes;
}
} 
