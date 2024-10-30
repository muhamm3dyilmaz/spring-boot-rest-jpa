package com.proj.spring_boot_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proj.spring_boot_rest.model.JobPost;

@Repository
public interface JobRepository extends JpaRepository<JobPost, Integer> {

}

// // method to return all JobPosts
// public List<JobPost> returnAllJobPosts() {
// return jobs;
// }

// // method to save a job post object into arrayList
// public void addJobPost(JobPost job) {
// jobs.add(job);

// }

// public JobPost getJob(int postId) {
// for (JobPost job : jobs) {
// if (job.getPostId() == postId) {
// return job;
// }
// }

// return null;
// }

// public void updateJob(JobPost jobPost) {
// for (JobPost jp : jobs) {
// if (jp.getPostId() == jobPost.getPostId()) {
// jp.setPostProfile(jobPost.getPostProfile());
// jp.setPostDesc(jobPost.getPostDesc());
// jp.setReqExperience(jobPost.getReqExperience());
// jp.setPostTechStack(jobPost.getPostTechStack());
// }
// }
// }

// public void deleteJob(int postId) {
// for (JobPost jp : jobs) {
// if (jp.getPostId() == postId) {
// jobs.remove(postId);
// }
// }
// }
