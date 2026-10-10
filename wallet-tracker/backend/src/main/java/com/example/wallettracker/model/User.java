package com.example.wallettracker.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(nullable = false, length = 20)
    @NotBlank
    @Size(max = 20)
    private String name;

    @Column(length = 40)
    @Size(max = 40)
    private String lastName;

    @Column(nullable = false, unique = true, length = 40)
    @NotBlank
    @Email
    @Size(max = 40)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Categories> categories;

    @OneToMany(mappedBy = "user")
    private List<Balances> balances;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "user")
    private List<Budget> budgets;

    public Long getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
