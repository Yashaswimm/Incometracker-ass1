
package com.ust.Expensive_application.service;

import com.ust.Expensive_application.entity.Expense;
import com.ust.Expensive_application.repo.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public double getBalanceByDate(LocalDate date) {
        List<Expense> entries = expenseRepository.findByDate(date);
        double balance = 0;
        for (Expense exp : entries) {
            if (exp.isExpense()) {
                balance -= exp.getAmount();
            } else {
                balance += exp.getAmount();
            }
        }
        return balance;
    }

    public double getExpenseByPaymentMethod(String paymentMethod) {
        List<Expense> entries = expenseRepository.findByPaymentMethod(paymentMethod);
        double balance = 0;
        for (Expense exp : entries) {
            if (exp.isExpense()) {
                balance -= exp.getAmount();
            } else {
                balance += exp.getAmount();
            }
        }
        return balance;
    }

    public Expense addExpense(Expense exp) {
        return expenseRepository.saveAndFlush(exp);
    }
}

