/* (C)2024 */
package com.ironhack.ironlibrary.repository;

import com.ironhack.ironlibrary.model.Issue;
import com.ironhack.ironlibrary.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

    Optional<Issue> findIssueByIssueStudent(Student student);
}
