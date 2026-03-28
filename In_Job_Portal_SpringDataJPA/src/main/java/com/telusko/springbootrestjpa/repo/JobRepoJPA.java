package com.telusko.springbootrestjpa.repo;

import org.springframework.data.jpa.repository.JpaRepository
;
import org.springframework.stereotype.Repository;

import com.telusko.springbootrestjpa.model.JobPostJPA;

@Repository
public interface JobRepoJPA extends JpaRepository<JobPostJPA, Integer> {

	

}
