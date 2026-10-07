package com.example.wallettracker.model;
import jakarta.persistence.*;

@Entity
@Table (name = "CATEGORIES")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_category;

    @Column(nullable = false, length = 20)
    private String name;

    @Column (nullable = true, length = 40)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

}
