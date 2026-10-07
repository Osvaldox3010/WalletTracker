package com.example.wallettracker.model;

// import jakarta.annotation.Generated;
import jakarta.persistence.*;
import java.util.List;

@Entity 
@Table (name = "USERS")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = true, length = 40)
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Categories> categories;

    @OneToMany(mappedBy = "user")
    private List<Balances> balances;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    private List<Budget> budgets;
}
