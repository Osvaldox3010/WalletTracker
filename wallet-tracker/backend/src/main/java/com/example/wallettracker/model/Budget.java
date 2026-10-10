package com.example.wallettracker.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "BUDGETS")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_budget;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal limit_amount;

    @Column(nullable = false)
    private LocalDate start_date;

    @Column(nullable = false)
    private LocalDate end_date;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category", nullable = false)
    private Categories category;

    public Long getId_budget() {
        return id_budget;
    }

    public BigDecimal getLimit_amount() {
        return limit_amount;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public User getUser() {
        return user;
    }

    public Categories getCategory() {
        return category;
    }

    public void setLimit_amount(BigDecimal limit_amount) {
        this.limit_amount = limit_amount;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
