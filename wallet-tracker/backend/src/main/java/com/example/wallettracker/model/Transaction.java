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
}

enum TransactionType {
    INCOME,
    EXPENSE
}