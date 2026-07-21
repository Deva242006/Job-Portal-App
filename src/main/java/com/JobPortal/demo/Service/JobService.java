package com.JobPortal.demo.Service;

import com.JobPortal.demo.Model.Job;
import com.JobPortal.demo.Repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.Kernel;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepo repo;

    public List<Job> getAllJobs(){
        return repo.findAll();
    }

    public void saveJob(Job j1){
        j1.setCreated_At(LocalDate.now());
        repo.save(j1);
    }

    public void DelJob(int id){
        repo.deleteById(id);
    }
    public Job UpdateJob( Job updatedJob){


       return repo.save(updatedJob);
    }
    public List<Job> getByTitle(String keyword){
      return   repo.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Job> getByCompany(String keyword) {

        if(keyword.length()>2){
            return repo.findByCompanyIgnoreCase(keyword);
        }
        else {
            return Collections.singletonList(new Job());
        }
    }

    public Job GetByID(int id) {
        return  repo.findById(id).orElse(new Job());
    }
}
