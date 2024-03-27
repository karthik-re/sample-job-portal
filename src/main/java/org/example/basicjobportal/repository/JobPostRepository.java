package org.example.basicjobportal.repository;

import org.example.basicjobportal.entity.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface JobPostRepository extends JpaRepository<JobPost, Integer> {

    List<JobPost> findByCompanyNameOrderByPostedDateDesc(String companyName);

    List<JobPost> findByJobTypeOrderByPostedDateDesc(String jobType);

    List<JobPost> findByLocationOrderByPostedDateDesc(String location);

    List<JobPost> findByExperienceLessThanEqualOrderByPostedDateDesc(int experience);

    @Query("SELECT j FROM JobPost j WHERE j.postedDate >= :postedDate")
    List<JobPost> getJobsInLast24Hours(LocalDateTime postedDate);

}
