/* (C)2024 */
package com.ironhack.ironlibrary.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "issues")
@Data
@NoArgsConstructor
public class Issue {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String issueDate;
    private String returnDate;

    @OneToOne
    @JoinColumn(name = "issue_book")
    private Book issueBook;

    @OneToOne
    @JoinColumn(name = "issue_student")
    private Student issueStudent;
}
