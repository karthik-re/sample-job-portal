package org.example.basicjobportal.service;

import org.example.basicjobportal.entity.JobPost;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobService {
    JobPost saveJobPost(JobPost jobPost);

    List<JobPost> getAllJobPosts();

    JobPost getJobPostById(int id);

    void deleteJobPostById(int id);

    List<JobPost> getJobPostsByCompanyName(String companyName);

    List<JobPost> getJobPostsByJobType(String jobType);

    List<JobPost> getJobPostsByLocation(String location);

    List<JobPost> getJobPostsByExperience(int experience);

    @Query("SELECT j FROM JobPost j WHERE j.postedDate >= CURRENT_DATE - 1")
    List<JobPost> getJobPostsInLast24Hours();
}
