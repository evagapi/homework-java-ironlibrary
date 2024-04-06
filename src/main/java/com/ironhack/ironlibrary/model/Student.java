/* (C)2024 */
package com.ironhack.ironlibrary.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
public class Student {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String usn;
    private String name;

    public Student(String usn, String name) {
        this.usn = usn;
        this.name = name;
    }
}
