package com.kadri.springbootmongodbdemo.service;

import com.kadri.springbootmongodbdemo.model.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final com.kadri.springbootmongodbdemo.repository.ExpenseRepository expenseRepository;

    public ExpenseService(com.kadri.springbootmongodbdemo.repository.ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void add(Expense expense) {
        expenseRepository.insert(expense);
    }

    public void update(Expense expense) {
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find Expense by ID %s", expense.getId())));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(savedExpense);
    }

    public List<Expense> getAll() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException(
                String.format("Cannot Find Expense by Name: %s", name)
        ));
    }

    public void deleteExpense(String id) {
        expenseRepository.deleteById(id);
    }
}
