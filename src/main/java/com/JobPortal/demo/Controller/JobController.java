package com.JobPortal.demo.Controller;

import com.JobPortal.demo.Model.Job;
import com.JobPortal.demo.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class JobController {

    @Autowired
    JobService service;

    @GetMapping("/Jobs")
    public ResponseEntity<List<Job>> get(){
      return   new ResponseEntity<List<Job>>(service.getAllJobs(), HttpStatus.OK);
    }
    @GetMapping("/Job/{id}")
    public ResponseEntity<Job> getByID(@PathVariable int id){
        return new ResponseEntity<Job>(service.GetByID(id),HttpStatus.OK);
    }

    @PostMapping("/Job")
    public ResponseEntity<HttpStatus> save(@RequestBody Job j1){
        service.saveJob(j1);
        return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
    }

    @DeleteMapping("/Job/{id}")
    public ResponseEntity<HttpStatus> del(@PathVariable int id){
        service.DelJob(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }

    @PutMapping("/Job")
    public ResponseEntity<Job> update(@RequestBody Job j1){
        return new ResponseEntity<Job>(service.UpdateJob(j1),HttpStatus.ACCEPTED);
    }

    @GetMapping("/Job/{Keyword}")
    public ResponseEntity<List<Job>> getAllByTitle(@PathVariable String Keyword){
       return new ResponseEntity<List<Job>>( service.getByTitle(Keyword),HttpStatus.OK);
    }

    @GetMapping("/Job/byCompany/{Keyword}")
    public ResponseEntity<List<Job>>getAllByCompany(@PathVariable String Keyword){
        return new ResponseEntity<List<Job>>(service.getByCompany(Keyword),HttpStatus.OK);
    }

}
