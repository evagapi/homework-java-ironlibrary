/* (C)2024 */
package com.ironhack.ironlibrary.service;

import com.ironhack.ironlibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired private AuthorRepository authorRepository;
}
