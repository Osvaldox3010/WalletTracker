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
    private String source;

    @Column (nullable = false, length = 40)
    private String description;

    @Column (nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private CurrencyType currency; // USD, EUR, etc.

    @Column (nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private BalanceType balance_type;

    @Column (nullable = false, precision = 10, scale = 2)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany (mappedBy = "balances")
    private List<Transaction> transactions;

    public Long getId_balance() {
        return id_balance;
    }

    public String getSource() {
        return source;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrency() {
        return currency.name();
    }

    public String getBalance_type() {
        return balance_type.name();
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrency(CurrencyType currency) {
        this.currency = currency;
    }

    public void setBalance_type(BalanceType balance_type) {
        this.balance_type = balance_type;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}

enum BalanceType {
    CASH,
    BANK,
    CREDIT_CARD
}

enum CurrencyType {
    USD,
    EUR,
    GBP,
    JPY
}