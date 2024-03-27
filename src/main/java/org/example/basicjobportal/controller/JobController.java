package org.example.basicjobportal.controller;

import org.example.basicjobportal.entity.JobPost;
import org.example.basicjobportal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class JobController {

    private final JobService jobPostService;

    @Autowired
    public JobController(JobService jobPostService) {
        this.jobPostService = jobPostService;
    }

    @GetMapping("/test")
    public String test() {
        return "Hello World";
    }

    @GetMapping("/jobposts")
    public ResponseEntity<List<JobPost>> getJobPosts() {
        return ResponseEntity.ok(jobPostService.getAllJobPosts());
    }

    @GetMapping("/jobposts/{id}")
    public ResponseEntity<JobPost> getJobPostById(@PathVariable int id) {
        return ResponseEntity.ok(jobPostService.getJobPostById(id));
    }

    @PostMapping("/jobposts")
    public ResponseEntity<JobPost> saveJobPost(@RequestBody JobPost jobPost) {
        jobPost.setJobId(0);
        jobPost.setPostedDate(new java.util.Date());
        return ResponseEntity.ok(jobPostService.saveJobPost(jobPost));
    }

    @PutMapping("/jobposts")
    public ResponseEntity<JobPost> updateJobPost(@RequestBody JobPost jobPost) {
        return ResponseEntity.ok(jobPostService.saveJobPost(jobPost));
    }

    @DeleteMapping("/jobposts/{id}")
    public ResponseEntity<String> deleteJobPost(@PathVariable int id) {
        jobPostService.deleteJobPostById(id);
        return ResponseEntity.ok("Job Post with id " + id + " deleted successfully");
    }

    @GetMapping("/jobposts/company")
    public ResponseEntity<List<JobPost>> getJobPostsByCompanyName(@RequestParam  String companyName) {
        return ResponseEntity.ok(jobPostService.getJobPostsByCompanyName(companyName));
    }

    @GetMapping("/jobposts/jobtype")
    public ResponseEntity<List<JobPost>> getJobPostsByJobType(@RequestParam String jobType) {
        return ResponseEntity.ok(jobPostService.getJobPostsByJobType(jobType));
    }

    @GetMapping("/jobposts/location")
    public ResponseEntity<List<JobPost>> getJobPostsByLocation(@RequestParam String location) {
        return ResponseEntity.ok(jobPostService.getJobPostsByLocation(location));
    }

    @GetMapping("/jobposts/experience")
    public ResponseEntity<List<JobPost>> getJobPostsByExperience(@RequestParam int experience) {
        return ResponseEntity.ok(jobPostService.getJobPostsByExperience(experience));
    }

    @GetMapping("/jobposts/recent")
    public ResponseEntity<List<JobPost>> getJobPostsInLast24Hours(@RequestParam int numberOfHours) {
        return ResponseEntity.ok(jobPostService.getJobPostsInLast24Hours());
    }

}
