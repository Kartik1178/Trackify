package com.example.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import java.util.UUID;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

@Serdeable
@MappedEntity
public class Expense {
 @Id
 @GeneratedValue
 private Long id;

@Column(name="bill_no",nullable = false,updatable = false,unique = true)
private String bill_no;

 @Column(name="description")
    private String description;

 @Column(name="amount")
     private Integer amount;

@Column(name="expense_date")
@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate expense_date;

@Column(name="sent_to")
    private String sent_to;


@Column(name="isactive")
    private boolean isactive=true;

@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="type_id",nullable = false)
private CategoryType categoryTypes;

public Expense(){
    this.bill_no=generateUUID();
}
private String generateUUID(){
final String Alphanumeric="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
final SecureRandom random=new SecureRandom();
StringBuilder sb=new StringBuilder(6);
for(int  i=0;i<8;i++){
sb.append(Alphanumeric.charAt(random.nextInt(Alphanumeric.length())));
}
return sb.toString();
}
public Long getId(){
    return id;
}
public void setId(Long id){
    this.id = id;
}
public String getDescription(){
    return description;
}
public void setDescription(String description){
    this.description = description;
}
public Integer getAmount(){
    return amount;

}
public void setAmount(Integer amount){
    this.amount = amount;
}
public CategoryType getCategoryTypes(){
    return categoryTypes;
}
public void setCategoryTypes(CategoryType categoryTypes){
    this.categoryTypes = categoryTypes;
}
public LocalDate getExpense_date() {
    return expense_date;
}
public void setExpense_date(LocalDate expense_date) {
    this.expense_date = expense_date;
}

    public boolean isIsactive() {
        return isactive;
    }
    public void setIsactive(boolean isactive) {
        this.isactive = isactive;
    }
    public String getSent_to() {
    return sent_to;
    }
    public void setSent_to(String sent_to) {
    this.sent_to = sent_to;
    }

public  String getBill_no(){
    return bill_no;
}

}
