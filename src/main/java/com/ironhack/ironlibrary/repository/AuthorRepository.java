/* (C)2024 */
package com.ironhack.ironlibrary.repository;

import com.ironhack.ironlibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    Optional<Author> findAuthorByName(String authorName);


}
