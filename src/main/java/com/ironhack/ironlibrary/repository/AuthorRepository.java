package com.ironhack.ironlibrary.repository;

import com.ironhack.ironlibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
