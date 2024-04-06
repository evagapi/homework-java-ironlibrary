/* (C)2024 */
package com.ironhack.ironlibrary.service;

import com.ironhack.ironlibrary.model.Author;
import com.ironhack.ironlibrary.model.Issue;
import com.ironhack.ironlibrary.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssueService {
    @Autowired private IssueRepository issueRepository;

    public void saveIssue(Issue issue) {
        issueRepository.save(issue);
    }

    public Issue issueBookToStudent(Issue issue) {
        return issueRepository.save(issue);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }
}
