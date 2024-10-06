
package com.ust.Expensive_application.controller;

import com.ust.Expensive_application.entity.Expense;
import com.ust.Expensive_application.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/expensive")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/balance/date")
    public ResponseEntity<Double> getBalanceByDate(
            @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        double balance = expenseService.getBalanceByDate(date);
        return ResponseEntity.ok(balance);
    }

    @GetMapping("/balance/payment-method")
    public ResponseEntity<Double> getExpenseByPaymentMethod(
            @RequestParam("paymentMethod") String paymentMethod) {
        double balance = expenseService.getExpenseByPaymentMethod(paymentMethod);
        return ResponseEntity.ok(balance);
    }

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@Valid @RequestBody Expense expense) {
        Expense createdExpense = expenseService.addExpense(expense);
        return ResponseEntity.status(200).body(createdExpense);
    }
}





