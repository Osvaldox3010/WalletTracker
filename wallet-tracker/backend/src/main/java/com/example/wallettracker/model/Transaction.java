package com.example.wallettracker.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;

@Entity 
@Table (name = "TRANSACTIONS")
public class Transaction {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_transaction;

    @Column (nullable = false, length = 20)
    private String name; //gas, food, etc.

    @Column (nullable = true, length = 40)
    private String description;

    @Column (nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private TransactionType transaction_type;

    @Column (nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column (nullable = false, length = 20)
    private LocalDateTime transaction_date;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_balance")
    private Balances balances;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_category")
    private Categories categories;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId_transaction() {
        return id_transaction;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTransaction_type() {
        return transaction_type.name();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransaction_date() {
        return transaction_date;
    }

    public Balances getBalances() {
        return balances;
    }

    public Categories getCategories() {
        return categories;
    }

    public User getUser() {
        return user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTransaction_type(TransactionType transaction_type) {
        this.transaction_type = transaction_type;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTransaction_date(LocalDateTime transaction_date) {
        this.transaction_date = transaction_date;
    }

    public void setBalances(Balances balances) {
        this.balances = balances;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

enum TransactionType {
    INCOME,
    EXPENSE
}