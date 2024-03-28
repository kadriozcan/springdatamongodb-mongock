package com.kadri.springbootmongodbdemo.migration;

import com.kadri.springbootmongodbdemo.model.Expense;
import com.kadri.springbootmongodbdemo.model.ExpenseCategory;
import com.kadri.springbootmongodbdemo.repository.ExpenseRepository;
import io.mongock.api.annotations.ChangeUnit;
import io.mongock.api.annotations.Execution;
import io.mongock.api.annotations.RollbackExecution;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.math.BigDecimal;

@ChangeUnit(id = "expense-initializer", order = "001", author = "kadri")
public class ExpenseInitializerChangeUnit {

    private final ExpenseRepository expenseRepository;
    private final MongoTemplate mongoTemplate;

    public ExpenseInitializerChangeUnit(ExpenseRepository expenseRepository, MongoTemplate mongoTemplate) {
        this.expenseRepository = expenseRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Execution
    public void execution(ExpenseRepository expenseRepository) {
        Expense expense = new Expense();
        expense.setExpenseName("Movie Tickets");
        expense.setExpenseAmount(BigDecimal.valueOf(25));
        expense.setExpenseCategory(ExpenseCategory.ENTERTAINMENT);

        expenseRepository.save(expense);
    }

    @RollbackExecution
    public void rollbackExecution(ExpenseRepository expenseRepository) {
        // code to undo the changes made in the execution method
    }


}
