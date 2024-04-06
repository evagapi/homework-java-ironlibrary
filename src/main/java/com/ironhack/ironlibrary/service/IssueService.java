/* (C)2024 */
package com.ironhack.ironlibrary.service;

import com.ironhack.ironlibrary.model.Issue;
import com.ironhack.ironlibrary.model.Student;
import com.ironhack.ironlibrary.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IssueService {
    @Autowired private IssueRepository issueRepository;

    public void saveIssue(Issue issue) {
        issueRepository.save(issue);
    }

    public Issue issueBookToStudent(Issue issue) {
        return issueRepository.save(issue);
    }

    public Optional<Issue> findIssueByStudent(Student student) {
        return issueRepository.findIssueByIssueStudent(student);
    }
}
