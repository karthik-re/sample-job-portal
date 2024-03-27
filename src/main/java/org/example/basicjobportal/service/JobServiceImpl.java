package org.example.basicjobportal.service;

import org.example.basicjobportal.entity.JobPost;
import org.example.basicjobportal.repository.JobPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService{

    private final JobPostRepository jobPostRepository;


    @Autowired
    public JobServiceImpl(JobPostRepository jobPostRepository) {
        this.jobPostRepository = jobPostRepository;
    }

    @Override
    public JobPost saveJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);
        return jobPost;
    }

    @Override
    public List<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    @Override
    public JobPost getJobPostById(int id) {
        Optional<JobPost> jobPost = jobPostRepository.findById(id);

        JobPost jobPost1 = null;

        if(jobPost.isPresent()){
            jobPost1 = jobPost.get();
        }
        return jobPost1;
    }

    @Override
    public void deleteJobPostById(int id) {
        jobPostRepository.deleteById(id);
    }

    @Override
    public List<JobPost> getJobPostsByCompanyName(String companyName) {
        return jobPostRepository.findByCompanyNameOrderByPostedDateDesc(companyName);
    }

    @Override
    public List<JobPost> getJobPostsByJobType(String jobType) {
        return jobPostRepository.findByJobTypeOrderByPostedDateDesc(jobType);
    }

    @Override
    public List<JobPost> getJobPostsByLocation(String location) {
        return jobPostRepository.findByLocationOrderByPostedDateDesc(location);
    }

    @Override
    public List<JobPost> getJobPostsByExperience(int experience) {
        return jobPostRepository.findByExperienceLessThanEqualOrderByPostedDateDesc(experience);
    }

    @Override
    public List<JobPost> getJobPostsInLast24Hours() {
        LocalDateTime postedDate = LocalDateTime.now().minusDays(1);
        return jobPostRepository.getJobsInLast24Hours(postedDate);
    }

}
