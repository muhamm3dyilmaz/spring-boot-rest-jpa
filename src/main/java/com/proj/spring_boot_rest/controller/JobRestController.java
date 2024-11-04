package com.proj.spring_boot_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.proj.spring_boot_rest.model.JobPost;
import com.proj.spring_boot_rest.service.JobService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin("http://localhost:3000")
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    public List<JobPost> getAllJobs() {
        return jobService.getAllJobs();
    };

    @GetMapping("jobPost/{postId}")
    public JobPost getjob(@PathVariable("postId") int postId) {
        return jobService.getJob(postId);
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> getMethodName(@PathVariable("keyword") String keyword) {
        return jobService.search(keyword);
    }
    
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost) {
        jobService.addJobPost(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @PutMapping("jobPost")
    public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable int postId){
        jobService.deleteJob(postId);
        return "Job Deleted";
    }

    @GetMapping("load")
    public String loadData() {
        jobService.load();
        return "success";
    }
    

}
