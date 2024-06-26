/* (C)2024 */
package com.ironhack.ironlibrary.service;

import com.ironhack.ironlibrary.model.Author;
import com.ironhack.ironlibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired private AuthorRepository authorRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Optional<Author> searchBookByAuthor(String authorName) {
        return authorRepository.findAuthorByName(authorName);
    }

}
