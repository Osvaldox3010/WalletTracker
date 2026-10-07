package com.example.wallettracker.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity 
@Table (name = "BALANCES")
public class Balances {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id_balance;

    @Column(nullable = false, length = 20, unique = true)
    private String source; // bank, cash, etc.

    @Column (nullable = false, length = 40)
    private String description;

    @Column (nullable = false, length = 20)
    private String currency; // USD, EUR, etc.

    @Column (nullable = false, length = 20)
    private Integer balance_type;

    @Column (nullable = false, precision = 10, scale = 2)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany (mappedBy = "balances")
    private List<Transaction> transactions;

}
