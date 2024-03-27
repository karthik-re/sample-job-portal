package org.example.basicjobportal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "job_post")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int jobId;

    private String jobTitle;

    private String jobDescription;

    private int experience;

    private String location;

    private String jobType;

    private String companyName;

    private Date postedDate;

//    public JobPost(String jobTitle, String jobDescription, int experience, String location, String jobType, String companyName) {
//        this.jobTitle = jobTitle;
//        this.jobDescription = jobDescription;
//        this.experience = experience;
//        this.location = location;
//        this.jobType = jobType;
//        this.companyName = companyName;
//    }
}
