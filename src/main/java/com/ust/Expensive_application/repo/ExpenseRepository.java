
package com.ust.Expensive_application.repo;

import com.ust.Expensive_application.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    List<Expense> findByDate(LocalDate date);
    List<Expense> findByPaymentMethod(String paymentMethod);
}


