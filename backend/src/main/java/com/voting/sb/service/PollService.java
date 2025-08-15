package com.voting.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.voting.sb.entity.OptionVotes;
import com.voting.sb.entity.Poll;
import com.voting.sb.execaption.ResourceNotFound;
import com.voting.sb.repository.PollRepo;

@Service
public class PollService {
	private final PollRepo pollRepo; 
	public PollService(PollRepo pollRepo) {
		this.pollRepo = pollRepo;
	}
	
	public Poll createPoll(Poll poll) {
		return  pollRepo.save(poll);
	}
	public Optional<Poll> getPoll(Long id) {
return pollRepo.findById(id);
	}
	public List<Poll> getAllPolls(){
	return 	pollRepo.findAll();
	}
	public Poll vote(long pollId,int optionIndex) {
	
		   Poll poll = pollRepo.findById(pollId)
	                .orElseThrow(() -> new RuntimeException("Poll not found"));

	        poll.getOptions().get(optionIndex).setVoteCount(
	            poll.getOptions().get(optionIndex).getVoteCount() + 1
	        );

	        return pollRepo.save(poll); // 🔹 Persist change in DB
		
		
	}
	}
	


