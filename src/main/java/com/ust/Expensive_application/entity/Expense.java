
package com.ust.Expensive_application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@Entity
@Table(name = "expense_tracker")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "date")
    @NotNull
    private LocalDate date;

    @Column(name = "amount")
    @NotNull
    @Min(value = 0, message = "Amount should be greater than 0")
    private double amount;

    @Column(name = "isExpense")
    @NotNull
    private boolean isExpense;

    @Column(name = "payment_method")
    @NotNull
    @Pattern(regexp = "CASH|BANK", message = "Payment method should be either CASH or BANK")
    private String paymentMethod;

    // Constructors

    public Expense() {
    }

    public Expense(long id, String description, LocalDate date, double amount, boolean isExpense, String paymentMethod) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.isExpense = isExpense;
        this.paymentMethod = paymentMethod;
    }

    // Getters and Setters

    public long getId() {
        return id;
    }

    // No setter for ID as it's auto-generated

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        isExpense = expense;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}


