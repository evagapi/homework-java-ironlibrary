/* (C)2024 */
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
    private String title;
    private String isbn;
    private String category;
    private int quantity;

    public Book(String title, String isbn, String category, int quantity) {
        this.title = title;
        this.isbn = isbn;
        this.category = category;
        this.quantity = quantity;
    }
}
