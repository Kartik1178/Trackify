package com.example.service;

import com.example.model.Category;
import com.example.model.CategoryType;
import com.example.model.Expense;
import com.example.repository.ExpenseRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDate;
import java.util.List;

@Singleton
public class ExpenseService {
    @Inject
    private ExpenseRepository expenseRepository;

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Category findCategory(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new RuntimeException("Expense not found"));
        CategoryType categoryType = expense.getCategoryTypes();
        if (categoryType == null) {
            throw new RuntimeException("CategoryType not found for Expense ID: " + expenseId);
        }
        Category category =categoryType.getCategory();
        if (category == null) {
            throw new RuntimeException("Category not found for Expense ID: " + expenseId);
    }
return category;}
public List<Expense> getExpenseByCategory(Long categoryId, Integer month,Integer year){
if(month==null||year==null){
    throw new RuntimeException("Month and year required");
}
LocalDate startDate=LocalDate.of(year,month,1);
LocalDate endDate=startDate.withDayOfMonth(startDate.lengthOfMonth());

       return expenseRepository.findCategoryId(categoryId,startDate,endDate);

}
public Expense deactivateExpense(Long id){
 Expense expense=expenseRepository.findById(id).orElseThrow(()->new RuntimeException("Expense not found"));
 expense.setIsactive(false);
 return expenseRepository.update(expense);
    }
public Expense modifyExpense(Long id, Expense newExpense){
        Expense oldExpense=expenseRepository.findById(id).orElseThrow(()->new RuntimeException("Expense not found"));
       if(newExpense.getExpense_date()!=null){
        oldExpense.setExpense_date(newExpense.getExpense_date());}
       if(newExpense.getSent_to()!=null){
        oldExpense.setSent_to((newExpense.getSent_to()));}
       if(newExpense.getAmount()!=null){
       oldExpense.setAmount(newExpense.getAmount());}
       if(newExpense.getDescription()!=null){
        oldExpense.setDescription(newExpense.getDescription());}
        return expenseRepository.update(oldExpense);
}
}