package com.example.controller;

import com.example.model.Category;
import com.example.model.CategoryType;
import com.example.model.Expense;
import com.example.repository.CategoryTypeRepository;
import com.example.repository.ExpenseRepository;
import com.example.service.ExpenseService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Controller("/expense")
public class ExpenseController {
    @Inject
    private ExpenseService expenseService;
    @Inject
    private ExpenseRepository expenseRepository;
    @Inject
    private CategoryTypeRepository categoryTypeRepository;
    @Post("/")
    public Expense createExpense(@Body Map<String, Object> request) {
        Long typeId = Long.valueOf(request.get("type_id").toString());
        CategoryType categoryType = categoryTypeRepository.findById(typeId)
                .orElseThrow(() -> new RuntimeException("CategoryType not found"));
        Expense expense = new Expense();
        expense.setDescription((String) request.get("description"));
        expense.setAmount(Integer.valueOf(request.get("amount").toString()));
        expense.setExpense_date(LocalDate.parse((String) request.get("expense_date")));
        expense.setSent_to((String) request.get("sent_to"));
        expense.setCategoryTypes(categoryType);
        return expenseService.createExpense(expense);
    }

    @Get("/{id}")
    public Category getCategory(@PathVariable Long id){
        return expenseService.findCategory(id);
}
@Get("/")
public List<Expense> findall(){
        return expenseRepository.findAll();
}

@Get("/findcategory/{id}/{month}/{year}")
    public List<Expense> getExpensesByCategory(@PathVariable Long id,@PathVariable Integer month,@PathVariable Integer year )
{return expenseService.getExpenseByCategory(id,month,year);}

@Patch("/deactivate/{id}")
public Expense deactivateExpense(@PathVariable Long id){
    return expenseService.deactivateExpense(id);
}
@Patch("/modifyExpense/{id}")
    public Expense modifyExpense(@PathVariable Long id,@Body Expense updatedExpense ){
      return  expenseService.modifyExpense(id,updatedExpense);
}

}