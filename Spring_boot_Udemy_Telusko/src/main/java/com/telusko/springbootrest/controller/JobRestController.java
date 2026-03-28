package com.telusko.springbootrest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;


import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.telusko.springbootrest.model.JobPost;
import com.telusko.springbootrest.service.JobService;

@RestController	
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
	
	@Autowired
	private JobService service;
	
	
	@GetMapping(path="jobPosts",produces = {"application/json", "application/xml"})
	public List<JobPost> getAllJobs() {
		return service.getAllJobs();
		
	}
	
	@GetMapping("/jobPost/{postId}")
	public JobPost getJob(@PathVariable("postId") int postId) {
		return service.getJob(postId);
	}
	
	@PostMapping("jobPost")
	public JobPost addJob(@RequestBody JobPost jobPost) {
		service.addJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	@PutMapping("jobPost")
	public JobPost updateJob(@RequestBody JobPost jobPost) {
		service.updateJob(jobPost);
		return service.getJob(jobPost.getPostId());
	}
	
	@DeleteMapping("jobPost/{postId}")
	public String deleteJob(@PathVariable int postId)
	{
		service.deleteJob(postId);
		return "Deleted";
	}
	

}
