package com.JobPortal.demo.Repo;

import com.JobPortal.demo.Model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<Job,Integer> {

    public List<Job> findByTitleContainingIgnoreCase(String keyword);
    public List<Job> findByCompanyIgnoreCase(String Keyword);
}
