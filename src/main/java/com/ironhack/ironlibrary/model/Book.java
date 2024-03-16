package com.ironhack.ironlibrary.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private String category;
    private int quantity;

    public Book(String isbn, String category, int quantity) {
        this.isbn = isbn;
        this.category = category;
        this.quantity = quantity;
    }
}
