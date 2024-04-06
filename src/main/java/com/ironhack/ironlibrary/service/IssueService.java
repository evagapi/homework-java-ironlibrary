/* (C)2024 */
package com.ironhack.ironlibrary.service;

import com.ironhack.ironlibrary.model.Issue;
import com.ironhack.ironlibrary.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueService {
    @Autowired private IssueRepository issueRepository;

    public Issue issueBookToStudent(Issue issue) {
        return issueRepository.save(issue);
    }
}
