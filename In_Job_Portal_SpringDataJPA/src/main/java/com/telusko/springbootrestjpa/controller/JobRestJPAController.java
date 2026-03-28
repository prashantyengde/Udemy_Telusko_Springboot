package com.telusko.springbootrestjpa.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.springbootrestjpa.model.JobPostJPA;
import com.telusko.springbootrestjpa.service.JobService;

@RestController	
public class JobRestJPAController {
	
	@Autowired
	private JobService service;
	
	
	

	@GetMapping("jobPosts")
	public List<JobPostJPA> getAllJobs() {
		return service.getAllJobs();
		
	}
	
	
	
	
	
	@GetMapping("/jobPost/{postId}")
	public JobPostJPA getJob(@PathVariable int postId) {
		return service.getJob(postId);
	}
	
	
	

	@PostMapping("jobPost")
	public JobPostJPA addJob(@RequestBody JobPostJPA jobPost) {
		service.addJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	
	
	@PutMapping("jobPost")
	public JobPostJPA updateJob(@RequestBody JobPostJPA jobPost) {
		service.updateJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	
	
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId)
	{
		service.deleteJob(postId);
		return "Deleted";
	}
	
	
	@GetMapping("load")
	public String loadData() {
		service.load();
		return "success";
	}


}
