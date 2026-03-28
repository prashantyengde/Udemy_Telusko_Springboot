package com.telusko.springbootrestjpa.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.springbootrestjpa.model.JobPostJPA;
import com.telusko.springbootrestjpa.repo.JobRepoJPA;


@Service
public class JobService {

	@Autowired
	public JobRepoJPA repo;
	
	
		
		
		
		//method to return all JobPosts
		public List<JobPostJPA> getAllJobs() {
			return repo.findAll();

			
		}
		
		
		
		


		
		
		
		// method to add a jobPost
		public void addJob(JobPostJPA jobPost) {
			 repo.save(jobPost);
		
		}




//method to get job by id
		public JobPostJPA getJob(int postId) {
			
			return repo.findById(postId).orElse(new JobPostJPA());
		}




//method to update job with job post object
		public void updateJob(JobPostJPA jobPost) {
		repo.save(jobPost);
			
		}




//method to delete job post by id 
		public void deleteJob(int postId) {
			repo.deleteById(postId);
			
		}









		public void load() {
			// arrayList to store store JobPost objects
//			List<JobPostJPA> jobs = 
//					new ArrayList<>(List.of(
//							new JobPostJPA(1, "Software Engineer", "Exciting opportunity for a skilled software engineer.", 3, List.of("Java", "Spring", "SQL")),
//							new JobPostJPA(2, "Data Scientist", "Join our data science team and work on cutting-edge projects.", 5, List.of("Python", "Machine Learning", "TensorFlow")),
//							 new JobPostJPA(3, "Frontend Developer", "Create amazing user interfaces with our talented frontend team.", 2, List.of("JavaScript", "React", "CSS")),
//							 new JobPostJPA(4, "Network Engineer", "Design and maintain our robust network infrastructure.", 4, List.of("Cisco", "Routing", "Firewalls")),
//							 new JobPostJPA(5, "UX Designer", "Shape the user experience with your creative design skills.", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
//
//					));
			
			/*List<JobPostJPA> jobs = new ArrayList<>();

			jobs.add(new JobPostJPA(1, "Software Engineer", 
			    "Exciting opportunity for a skilled software engineer.", 
			    3, List.of("Java", "Spring", "SQL")));

			jobs.add(new JobPostJPA(2, "Data Scientist", 
			    "Join our data science team and work on cutting-edge projects.", 
			    5, List.of("Python", "Machine Learning", "TensorFlow")));

			jobs.add(new JobPostJPA(3, "Frontend Developer", 
			    "Create amazing user interfaces with our talented frontend team.", 
			    2, List.of("JavaScript", "React", "CSS")));

			jobs.add(new JobPostJPA(4, "Network Engineer", 
			    "Design and maintain our robust network infrastructure.", 
			    4, List.of("Cisco", "Routing", "Firewalls")));

			jobs.add(new JobPostJPA(5, "UX Designer", 
			    "Shape the user experience with your creative design skills.", 
			    3, List.of("UI/UX Design", "Adobe XD", "Prototyping")));*/
			
			List<JobPostJPA> jobs = new ArrayList<>() {{
			    add(new JobPostJPA(1, "Software Engineer", 
			        "Exciting opportunity for a skilled software engineer.", 
			        3, List.of("Java", "Spring", "SQL")));
			        
			    add(new JobPostJPA(2, "Data Scientist", 
			        "Join our data science team and work on cutting-edge projects.", 
			        5, List.of("Python", "Machine Learning", "TensorFlow")));
			        
			    add(new JobPostJPA(3, "Frontend Developer", 
			        "Create amazing user interfaces with our talented frontend team.", 
			        2, List.of("JavaScript", "React", "CSS")));
			        
			    add(new JobPostJPA(4, "Network Engineer", 
			        "Design and maintain our robust network infrastructure.", 
			        4, List.of("Cisco", "Routing", "Firewalls")));
			        
			    add(new JobPostJPA(5, "UX Designer", 
			        "Shape the user experience with your creative design skills.", 
			        3, List.of("UI/UX Design", "Adobe XD", "Prototyping")));
			}};
			
			
		/*	List<JobPostJPA> jobs = new ArrayList<>();
			Collections.addAll(jobs,
			    new JobPostJPA(1, "Software Engineer", "...", 3, List.of("Java", "Spring", "SQL")),
			    new JobPostJPA(2, "Data Scientist", "...", 5, List.of("Python", "Machine Learning", "TensorFlow")),
			    new JobPostJPA(3, "Frontend Developer", "...", 2, List.of("JavaScript", "React", "CSS")),
			    new JobPostJPA(4, "Network Engineer", "...", 4, List.of("Cisco", "Routing", "Firewalls")),
			    new JobPostJPA(5, "UX Designer", "...", 3, List.of("UI/UX Design", "Adobe XD", "Prototyping"))
			);*/
		
			repo.saveAll(jobs);
			
		}



	
}
