package com.ironhack.ironlibrary.repository;

import com.ironhack.ironlibrary.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {
}
